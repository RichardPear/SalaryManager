app.controller('ModifyPackageController', ['$scope', '$rootScope', 'pengingHttp', function($scope, $rootScope, pengingHttp) {
    $scope.packageId = $rootScope.editPackageId;
    $rootScope.packageId = null;


    var getPackageData = function() {
        var promise = pengingHttp.get('api/package/info', {
            id: $scope.packageId
        });
        promise.then(function(data, status) {
            $scope.currPackage = data.data.interfaces;
        });
        promise.catch(function(data) {
            alert(data);
        });
    };



    //返回正常视图
    var toNormalView = function() {
            $rootScope.packageURL = "./package/package-index.html";
            $rootScope.currentOperation = "";
        }
        //取消修改
    $scope.cancel = function() {
        toNormalView();
        $rootScope.currPackage = {};
    };
    //修改
    $scope.update = function(p) {
        var promise = pengingHttp.post("api/package/update", p);
        promise.then(function(data) {
            toNormalView();
        });
        promise.catch(function(data) {
            toNormalView();
            alert("修改失败");
        });

    }
    getPackageData();
}]);