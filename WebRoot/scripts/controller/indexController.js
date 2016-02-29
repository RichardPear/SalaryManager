app.controller('indexController', ['$rootScope', '$scope', function($rootScope, $scope) {
    //$rootScope.serverUrl='server/serverList.html';
    $scope.showInterface = function() {

        $rootScope.interfaceViewUrl = './interface/interface-list.html';
        $rootScope.currentModule = "接口管理";
        $rootScope.currentOperation="";


    };
    $scope.showServer = function() {

        $rootScope.serverUrl = './server/server-list.html';
        $rootScope.currentModule = "服务器管理";
        $rootScope.currentOperation="";


    };



     //package跳转
    $scope.showPackage = function() {
        $rootScope.packageURL = './package/package-normal.html';
        $rootScope.currentModule = "软件包管理";
        $rootScope.currentOperation="";
    }

}])