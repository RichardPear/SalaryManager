<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--Basic Styles-->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
  <!--Beyond styles-->
  <link id="beyond-link" href="assets/css/beyond.min.css" rel="stylesheet" />
  <link href="assets/css/animate.min.css" rel="stylesheet" />
  <!--My styles-->
  <link rel="stylesheet" type="text/css" href="css/common.css"/>
  <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
  <script src="assets/js/skins.min.js"></script>
  </head>
  
  <body ng-app="app">
		<%
		if(session.getAttribute("user") == null || (String)session.getAttribute("user") == ""){
			response.sendRedirect("login.jsp");
			//<jsp:forward page="/login.jsp"></jsp:forward>
		 }%>
  	<!-- Loading Container -->
    <div class="loading-container">
        <div class="loading-progress">
            <div class="rotator">
                <div class="rotator">
                    <div class="rotator colored">
                        <div class="rotator">
                            <div class="rotator colored">
                                <div class="rotator colored"></div>
                                <div class="rotator"></div>
                            </div>
                            <div class="rotator colored"></div>
                        </div>
                        <div class="rotator"></div>
                    </div>
                    <div class="rotator"></div>
                </div>
                <div class="rotator"></div>
            </div>
            <div class="rotator"></div>
        </div>
    </div>
    <!--  /Loading Container -->
    <%@ include file="navbar.jsp" %> 
    <!-- Main Container -->
    <div class="main-container container-fluid">
	    <!-- Page Container -->
	    <div class="page-container">
	    	<%@ include file="siderbar.jsp" %>
	    	<div class="page-content">
	    			<!-- 页面位置导航 -->
            <div class="page-breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul>
            </div>
        		<!-- /页面位置导航 -->
         		<!-- 页头 -->
            <div class="page-header position-relative">
                <div class="header-title">
                    <h1>
                        Dashboard
                    </h1>
                </div>
                <!--Header Buttons-->
                <div class="header-buttons">
                    <a class="sidebar-toggler" href="#">
                        <i class="fa fa-arrows-h"></i>
                    </a>
                    <a class="refresh" id="refresh-toggler" href="">
                        <i class="glyphicon glyphicon-refresh"></i>
                    </a>
                    <a class="fullscreen" id="fullscreen-toggler" href="#">
                        <i class="glyphicon glyphicon-fullscreen"></i>
                    </a>
                </div>
                <!--Header Buttons End-->
            </div>
        		<!-- /页头 -->
        		<!--主视图-->
        		<div class="page-body">
        			
        		</div>
        		<!--/主视图-->
	    	</div>
	    </div>
	    <!-- Page Container -->
    </div>
    <!-- Main Container -->
    	
    <!--Basic Scripts-->
    <script src="assets/js/jquery-2.0.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
        <!--Beyond Scripts-->
    <script src="assets/js/beyond.min.js"></script>

    <!--Angular-->
    <script type="text/javascript" src="assets/js/angular.js"></script>
    <script type="text/javascript" src="assets/js/angular-ui-router.min.js"></script>
    <script type="text/javascript" src="assets/js/ui-bootstrap-tpls-0.14.3.js"></script>
    <script type="text/javascript" src="scripts/app.js"></script>
  </body>
</html>
