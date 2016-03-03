app.controller("homeController",["$scope","$http",function($scope,$http){
	$scope.read = function(obj){
		$scope.readObj = {};
		$scope.readObj.title = obj.notification.title;
		$scope.readObj.content = obj.notification.content;
		obj.status = 1;//已读标记
	}
	$scope.checkedLength = 0;
	$scope.check = function(id,flag){
		if(flag){
			$scope.checkedLength ++;
		}else{
			$scope.checkedLength --;
		}
	}
	$scope.allSelect = function(flag){
		checkbox = flag;
	}
	//获取我的通知
	$.ajax({
		url:  'getNotis.action',
		type: 'POST',
		success:function(data){
			var data = JSON.parse(data.json);
			console.log(data)
			$scope.notifications = data[0].data;
			$scope.$apply();//需要手动刷新 
		},
		error:function(errror){
			alert("服务器错误！");
		}
	});
	//获取我发布的通知
	$.ajax({
		url:  'getMyPubNotis.action',
		type: 'POST',
		success:function(data){
			$scope.myPubNotis = JSON.parse(data.json);
			$scope.$apply();//需要手动刷新 
		},
		error:function(errror){
			alert("服务器错误！");
		}
	});

}]);
