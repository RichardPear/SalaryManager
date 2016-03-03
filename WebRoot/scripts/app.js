var app = angular.module('app', ['ui.router', 'ui.bootstrap']);
app.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/home');
    // $urlRouterProvider.when('','html/port');
    $stateProvider
        .state('home', { //'home'与链接上的ui-sref的值相对应 ui-sref="home"
            url: '/home',
            templateUrl: 'home.jsp'
        })
        .state('department', {
            url: '/department',
            templateUrl: 'department.jsp'
        })
        .state('position', {
            url: '/position',
            templateUrl: 'position.jsp'

        })
        .state('employee', {
            url: '/employee',
            templateUrl: 'employee.jsp'

        })
        


})