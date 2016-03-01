<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 左侧导航栏 -->
<div class="page-sidebar" id="sidebar">
    <!-- Sidebar Menu -->
    <ul class="nav sidebar-menu">
        <!--首页-->
        <li ng-class="{active:currentModule=='home'}" ui-sref="home">
            <a href="javascript:void(0)" ng-click="toHome()">
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text">首页 </span>
            </a>
        </li>
        <!--首页-->
        <!--组织架构管理-->
        <li ng-class="{'open':isOrganizeOpen()}">
            <a href="javascript:void(0)" class="menu-dropdown">
                <i class="menu-icon fa fa-desktop"></i>
                <span class="menu-text"> 组织架构管理 </span>
                <i class="menu-expand"></i>
            </a>
            <ul class="submenu">
                <li ng-class="{active:currentModule=='department'}" ui-sref="department">
                    <a href="javascript:void(0)" ng-click="toDepartment()" >
                        <span class="menu-text">部门管理</span>
                    </a>
                </li>
                <li ng-class="{active:currentModule=='position'}" ui-sref="position">
                    <a href="javascript:void(0)" ng-click="toPosition()" >
                        <span class="menu-text">职位管理</span>
                    </a>
                </li>
                <li ng-class="{active:currentModule=='employee'}" ui-sref="employee">
                    <a href="javascript:void(0)" ng-click="toEmployee()" >
                        <span class="menu-text">人员管理</span>
                    </a>
                </li>
            </ul>
        </li>
        <!--组织架构管理-->
        <!--考勤中心-->
       <!--  <li ng-class="{active:currentModule=='attendance'}" ui-sref="attendance">
            <a href="javascript:void(0)" ng-click="toAttendance()">
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text">考勤中心 </span>
            </a>
        </li> -->
        <!--/考勤中心-->
        <!--薪资管理-->
        <!-- <li ng-class="{active:currentModule=='home'}" ui-sref="home">
            <a href="javascript:void(0)" ng-click="toHome()">
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text">首页 </span>
            </a>
        </li> -->
        <!--薪资管理-->
        <!--个人中心-->
        <!-- <li ng-class="{active:currentModule=='home'}" ui-sref="home">
            <a href="javascript:void(0)" ng-click="toHome()">
                <i class="menu-icon glyphicon glyphicon-home"></i>
                <span class="menu-text">首页 </span>
            </a>
        </li> -->
        <!--/个人中心-->
    </ul>
    <!-- /Sidebar Menu -->
</div>
<!-- /左侧导航栏 -->