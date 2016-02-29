/**
 * Created by Administrator on 2015/12/4.
 */
app.controller("PackageDeployController",['$scope','$rootScope','pengingHttp',function($scope,$rootScope,pengingHttp){
    $scope.packageId = $rootScope.editPackageId;

    //获取程序包数据
    var getPackageData = function() {
        var promise = pengingHttp.get('api/package/info', {
            id: $scope.packageId
        });
        promise.then(function(data, status) {
            if(data.trans.errorCode != null){
                alert(data.trans.replyText);
            }
            $scope.currPackage = data.data.interfaces;
        });
        promise.catch(function(data) {
            alert(data);
        });
    };
    //获取服务器列表
    var getServers = function(){
        var promise = pengingHttp.post("api/server/list");
        promise.then(function(data,status){
            if(data.trans.errorCode != null){
                alert(data.trans.replyText);
            }
            $scope.servers = data.data.interfaces;
            //console.log($scope.servers);
        });
        promise.catch(function(data) {
            alert(data);
        });
    };
    //获取程序包所在服务器
    var getPackageServerIds = function(){
        var promise = pengingHttp.post("api/package/servers",{id:$scope.packageId});
        promise.then(function(data,status){
            $scope.serverIds = data.data.serverIds;
        });
        promise.catch(function(data) {
            alert(data);
        });
    };

    getPackageServerIds();//获取已部署的服务器id

    //判断是否选中
    $scope.isChecked = function(id){
        ids = $scope.serverIds;
        for(var i = 0;i < ids.length;i ++){
            if(id == ids[i]){
                return true;
            }
        }
        return false;
    };

    //点击响应
    $scope.contentChange = function(serverId,flag){
        var promise = pengingHttp.post("api/package/deploy",{
            isDeploy:flag,
            serverId:serverId,
            packageId:$scope.packageId
        });
        promise.then(function(data){
            if(data.trans.errorCode != null){
                alert(data.trans.replyText);
            }
            //console.log(data)
        });
        promise.catch(function(data){
            //console.log(data.trans.replyText)
        });

    };
    getPackageData();//获取程序包信息
    getServers();//获取服务器列表
}]);