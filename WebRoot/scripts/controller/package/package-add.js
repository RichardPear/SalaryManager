app.controller('AddPackageController', ['$scope','$rootScope','pengingHttp',function($scope,$rootScope,pengingHttp){

    var cancel = $scope.cancel = function(){
        $rootScope.packageURL = "./package/package-index.html";
        $rootScope.currentOperation="";
    };
    //新增保存
	$scope.save = function(p){
        var id=createUUID();
        p.id=id;
        var promise = pengingHttp.post("api/package/create",p);
        promise.then(function(data,status){
            cancel();
        });
		promise.catch(function(data){
            cancel();
            alert("保存失败，请重试！");
        });

	}
}]);