app.controller('NormalController', ['$scope','$rootScope','pengingHttp',function($scope,$rootScope,pengingHttp){
    $scope.currentPage = 1;//当前页面
    $scope.itemPerPage = 2;//每页显示条数
    $scope.totalItems = 0;//总条数


    //跳转至新建页面
	$scope.toAddPage  = function(){
		$rootScope.packageURL = "./package/package-add.html";
        $rootScope.currentOperation = ">新建包";
	};

    //获取总的条数
    var getPackageCount = function(){
        var promise = pengingHttp.get('api/package/count');
        promise.then(function(data,status){
            $scope.totalItems = data.data;
        });
        promise.catch(function(data){
            alert("获取数据条数失败");
        });
    };
    //获取package list
    var getPackageList = function(){
        var data = {
            pager:{
                pageIndex: $scope.currentPage-1,
                itemPerPage: $scope.itemPerPage
            },
            criteria: $scope.filter
        };
        var promise = pengingHttp.post('api/package/list', data);
        promise.then(function(data,status) {
            $scope.packages = data.data.interfaces;
        });

        promise.catch(function(data) {
            alert("获取列表失败！");
        });
    };
    //搜索
	$scope.searchPackage = function(){
       getPackageList();
	};
    //修改
	$scope.modifyPackage = function(id){
        $rootScope.currentOperation = ">修改软件包";
		/*$rootScope.packageURL = "./package/package-modify.html";*/
        $rootScope.editPackageId=id;
        $rootScope.packageURL = "./package/package-modify.html";

	};
    //删除
	$scope.deletePackage = function(id){
        var promise = pengingHttp.post("api/package/delete", {id: id});
        promise.then(function(data,status){
            getPackageList();
            getPackageCount();//重新请求总条数
        });
        promise.catch(function(data){
            alert("删除失败，请重试！");
        });
	};
    //部署
    $scope.deployPackage = function(id){
        $rootScope.editPackageId=id;
        $rootScope.currentOperation = ">部署软件包";
        $rootScope.packageURL = "./package/package-deploy.html";
//        alert($rootScope.editPackageId);
    };
    //分页
    $scope.pageChanged = function() {
        getPackageList();
    };
    //初始化加载packages
    getPackageList();
    getPackageCount();


}]);
