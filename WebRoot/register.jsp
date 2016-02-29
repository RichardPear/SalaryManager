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
    <title>注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--Basic Styles-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--Beyond styles-->
    <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" />
    <link href="assets/css/animate.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/common.css" />
	<style type="text/css">
		select.form-control  {
			padding: 0;
		}
		
	</style>
</head>
<!--Head Ends-->
<!--Body-->
<body ng-controller="registerController">
    <div class="register-container animated fadeInDown">
    	<div class="widget flat radius-bordered">
        	<div class="widget-header bg-themeprimary">
        		<span class="widget-caption">欢迎使用薪资福利管理系统</span>
        	</div>
	        <div class="registerbox bg-white">
	            <div class="registerbox-title">注册</div>
	
	            <div class="registerbox-caption ">请填入注册的个人信息~~</div>
	            <form name="signupForm" novalidate ng-submit="register(user)">
	            	 <div class="registerbox-textbox">
		            	<label>
		                	<input name="sex" type="radio" value="1" ng-checked="true" ng-model="user.sex">
		                	<span class="text">男</span>
		            	</label>
		            	<label>
		                	<input name="sex" type="radio" value="0" ng-model="user.sex">
		                	<span class="text">女</span>
		            	</label>
		            </div>
		            <div class="error-container ng-cloak" ng-hide="unique || signupForm.username.$pristine">
		            	<span class="red">该用户名已被注册！</span>
		            </div>
		            <div class="error-container ng-cloak" ng-show="signupForm.username.$error.required && signupForm.username.$dirty">
		            	<span class="red">请输入用户名！</span>
		            </div>
		            <div class="error-container ng-cloak" ng-show="signupForm.username.$error.minlength && signupForm.username.$dirty">
		            	<span class="red">用户名必须在3个字符以上！</span>
		            </div>
		            <div class="error-container ng-cloak" ng-show="signupForm.username.$error.maxlength && signupForm.username.$dirty">
		            	<span class="red">用户名必须小于20个字符！</span>
		            </div>
		            <div class="registerbox-textbox">
		                <span class="icon-right input-icon">
		                	<input type="text" class="form-control" placeholder="用户名，唯一" required name="username"  ng-minlength=3 
            ng-maxlength=20  ng-model="user.username" />
		                	<i class="glyphicon glyphicon-user circular"></i>
		                </span>
		            </div>
		            <div class="registerbox-textbox">
                		<select name="department" class="form-control" ng-model="user.pid" required>
                			<option value="">选择所在部门</option>
                			<option value="{{dept.id}}" ng-repeat="dept in depts">{{dept.name}}</option>
            			</select>
		            </div>
		            <div class="registerbox-textbox">
		                <span class="input-icon icon-right">
		                	<input type="password" class="form-control" ng-model="user.password" placeholder="密码" required />
		                	<i class="fa-lock fa circular"></i>
		                </span>
		            </div>
		            <div class="registerbox-textbox">
		                <span class="input-icon icon-right">
		                	<input type="password" class="form-control" ng-model="password" placeholder="确认密码" required />
		                	<i class="fa-lock fa circular"></i>
		                </span>
		            </div>
		            <div class="registerbox-submit">
		                <input type="submit" class="btn btn-primary btn-block" ng-disabled="signupForm.$invalid || multiple" value="提交">
	                	<input type="reset" class="btn btn-blue btn-block" value="重置">
		            </div>
		            <div class="registerbox-textbox text-align-right">
		            	<a href="login.jsp">账号登录</a>
		            </div>
	            </form>
	        </div>
	    </div>
    </div>

    <!--Basic Scripts-->
    <script src="assets/js/jquery-2.0.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--Angular-->
    <script type="text/javascript" src="assets/js/angular.js"></script>
    <script type="text/javascript" src="assets/js/angular-ui-router.min.js"></script>
    <script type="text/javascript" src="assets/js/ui-bootstrap-tpls-0.14.3.js"></script>
    <script type="text/javascript" src="scripts/app.js"></script>
    <script type="text/javascript" src="scripts/controller/register/registerController.js"></script>
    <!--<script type="text/javascript" src="scripts/directive/register/ensure-unique.js"></script>-->
</body>
<!--Body Ends-->
</html>
