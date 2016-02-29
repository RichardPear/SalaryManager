/**
 * Created by Administrator on 2015/12/4.
 */
app.controller("PackageIndexController",['$scope','$rootScope','pengingHttp',function($scope,$rootScope,pengingHttp) {
    $rootScope.packageURL = './package/package-normal.html';
    $rootScope.currentModule = '软件包管理';

}]);