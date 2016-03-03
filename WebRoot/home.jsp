<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/home.css" />
<div class="row" ng-controller="homeController">
	<div class="col-xs-12 col-md-12">
		<div class="widget">
			<div class="widget-header bordered-bottom bordered-sky">
				<span class="widget-caption">我的通知</span>
			</div>
			<div class="widget-body">
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active">
                            <a data-toggle="tab" href="#atMe">
                                @我的
                            </a>
                        </li>

                        <li class="tab-red">
                            <a data-toggle="tab" href="#mine">
                                	我发布的
                            </a>
                        </li>
					</ul>
					<div class="tab-content">
                        <div id="atMe" class="tab-pane in active">
                        	<h2 ng-if="notifications.length == 0">暂无通知！</h2>
                        	<div ng-if="notifications.length > 0">
                        		<a class="btn btn-danger" href="javascript:void(0);"><i class="fa fa-times"></i>删除</a>
	                            <div class="btn-group">
	                                <a class="btn btn-maroon dropdown-toggle" data-toggle="dropdown">
	                                    	标记为 <i class="fa fa-angle-down"></i>
	                                </a>
	                                <ul class="dropdown-menu dropdown-maroon">
	                                   <li>
	                                        <a href="javascript:void(0);">已读</a>
	                                    </li>
	                                    <li>
	                                        <a href="javascript:void(0);">未读</a>
	                                    </li>
	                                </ul>
	                            </div>
                        	</div>
                            <table class="table table-striped  table-hover" id="notification-table" ng-if="notifications.length>0">
								<thead>
			                        <tr>
			                        	<th>
			                                  <div class="checkbox">
			                                    <label>
			                                        <input type="checkbox" ng-checked="checkedLength==notifications.length" ng-model="allChecked" ng-click="allSelect(this.allChecked)">
			                                        <span class="text"></span>
			                                    </label>
			                                </div>
			                            </th>
			                            <th>
			                                	发布时间
			                            </th>
			                            <th>
			                                	标题
			                            </th>
			                            <th>
			                                	发布者
			                            </th>
			                            <th>
			                                	操作
			                            </th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<tr ng-repeat="item in notifications" ng-class="{'my-unread':item.status==0}">
			                    		<td>
			                    			<div class="checkbox">
			                                    <label>
			                                        <input type="checkbox" ng-click="check(item.id,this.checkbox)" ng-model="checkbox">
			                                        <span class="text"></span>
			                                    </label>
			                                </div>
			                                  
			                    		</td>
			                    		<td>{{item.notification.createTime}}</td>
			                    		<td>{{item.notification.title}}</td>
			                    		<td>{{item.user.username}}</td>
			                    		<td><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#notification-info-modal" ng-click="read(item)">阅读</button></td>
			                    	</tr>
			                    </tbody>
							</table>
                        </div>

                        <div id="mine" class="tab-pane">
                        	<a class="btn btn-danger" href="javascript:void(0);" ng-if="myPubNotis.length>0"><i class="fa fa-times"></i>删除</a>
                        	<a class="btn btn-yellow" href="javascript:void(0);" ng-if="myPubNotis.length>0"><i class="fa fa-lock"></i>禁用</a>
                            <a class="btn btn-default purple" href="javascript:void(0);"><i class="fa fa-plus"></i>发布公告</a>
                            <h5 ng-if="myPubNotis.length==0">暂未发布任何通知！</h5>
                            
                            <table class="table table-striped  table-hover" id="my-notification-table" ng-if="myPubNotis.length>0">
								<thead>
			                        <tr>
			                        	<th>
			                                  <div class="checkbox">
			                                    <label>
			                                        <input type="checkbox" ng-checked="checkedLength==notifications.length" ng-model="allChecked" ng-click="allSelect(this.allChecked)">
			                                        <span class="text"></span>
			                                    </label>
			                                </div>
			                            </th>
			                            <th>
			                                	发布时间
			                            </th>
			                            <th>
			                                	标题
			                            </th>
			                            <th>
			                                	操作
			                            </th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    	<tr ng-repeat="item in myPubNotis">
			                    		<td>
			                    			<div class="checkbox">
			                                    <label>
			                                        <input type="checkbox" ng-click="check(item.id,this.checkbox)" ng-model="checkbox">
			                                        <span class="text"></span>
			                                    </label>
			                                </div>
			                                  
			                    		</td>
			                    		<td>{{item.createTime}}</td>
			                    		<td>{{item.title}}</td>
			                    		<!--<td><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#notification-info-modal" ng-click="read(item)">阅读</button></td>-->
			                    		<td>
			                    			<a href="javascript:void(0);" class="btn btn-danger btn-circle btn-xs" title="查看详情"><i class="glyphicon glyphicon-list"></i></a>
			                    		</td>
			                    	</tr>
			                    </tbody>
							</table>
                        </div>

                    </div>
				</div>
				<div class="horizontal-space"></div>

			</div>
		</div>
	</div>
</div>
<div id="notification-info-modal" class="modal  fade in" style="display: none;" aria-hidden="false" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="modal-title"><h5>阅读通知</h5></div>
                </div>
                <div class="modal-title text-align-center">{{readObj.title}}</div>

                <div class="modal-body">
                	<p class="text-align-justify" style="text-indent: 2em;">{{readObj.content}}</p>
                </div>
                <div class="modal-footer text-align-center">
                    <button type="button" class="btn btn-info" data-dismiss="modal">已阅</button>
                </div>
            </div> <!-- / .modal-content -->
        </div> <!-- / .modal-dialog -->
    </div>