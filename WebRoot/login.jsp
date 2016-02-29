<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入struts标签 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html ng-app="app">
<!--Head-->
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <!--Basic Styles-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="" rel="stylesheet" />
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--Fonts-->
    <!--Beyond styles-->
    <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" />
    <link href="assets/css/animate.min.css" rel="stylesheet" />
</head>
<!--Head Ends-->
<!--Body-->
<body ng-controller="loginController">
    <div class="login-container animated fadeInDown">
        <form name="loginForm" novalidate  ng-submit="login(user)">
        	<div class="widget flat radius-bordered">
	        	<div class="widget-header bg-themeprimary">
	        		<span class="widget-caption">欢迎使用薪资福利管理系统</span>
	        	</div>
	        	<div class="loginbox bg-white">
		            <div class="loginbox-title">登录</div>
		            <div class="loginbox-textbox">
		                <span class="icon-right input-icon">
		                	<input type="text" class="form-control" placeholder="用户名" ng-model="user.username" required />
		                	<i class="glyphicon glyphicon-user circular"></i>
		                </span>
		            </div>
		            <div class="loginbox-textbox">
		                <span class="input-icon icon-right">
		                	<input type="password" class="form-control" placeholder="密码" ng-model="user.password" required />
		                	<i class="fa-lock fa circular"></i>
		                </span>
		            </div>
		            <div class="loginbox-submit">
		                <input type="submit" class="btn btn-primary btn-block" value="登录" ng-disabled="loginForm.$invalid">
		            </div>
		            <div class="loginbox-signup">
		                <a href="register.jsp">注册通道</a>
		            </div>
	    		</div>
       		</div>
        </form>
    </div>
    <!--Basic Scripts-->
    <script src="assets/js/jquery-2.0.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <!--Angular-->
    <script type="text/javascript" src="assets/js/angular.js"></script>
    <script type="text/javascript" src="assets/js/angular-ui-router.min.js"></script>
    <script type="text/javascript" src="assets/js/ui-bootstrap-tpls-0.14.3.js"></script>
    <script type="text/javascript" src="scripts/app.js"></script>
    <script type="text/javascript" src="scripts/controller/login/loginController.js"></script>
</body>
<!--Body Ends-->
</html>

