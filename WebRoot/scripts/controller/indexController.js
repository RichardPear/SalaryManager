app.controller('indexController', ['$rootScope', '$scope', function($rootScope, $scope) {
	//判断是否登录
	$.get("isLogin.action");
	//当前模块
	var arr = location.href.split("/");
	$rootScope.currentModule = arr[arr.length-1];
	$scope.isOrganizeOpen = function(){
		var currentModule = $rootScope.currentModule;
		var flag = (currentModule=='department' || currentModule=='position' || currentModule=='employee');
		return flag;
	}
    $scope.toHome = function() {
    	$rootScope.currentModule = "home";
    };
    $scope.toDepartment = function(){
    	$rootScope.currentModule = "department";
    }
    $scope.toPosition = function(){
    	$rootScope.currentModule = "position";
    }
    $scope.toEmployee = function(){
    	$rootScope.currentModule = "employee";
    }
}])