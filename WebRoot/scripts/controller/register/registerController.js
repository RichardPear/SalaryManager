app.controller("registerController",["$scope","$http",function($scope,$http){
		//获取部门列表
		$http.get('department/list.action').success(function(data) {
    		$scope.depts = JSON.parse(data.json);
  		});
  		//用户名唯一性检查
  		$scope.unique = true;
  		$scope.multiple = !$scope.unique;
  		$scope.$watch("user.username",function(newValue,oldValue){
  			if(!newValue){
  				$scope.unique = true;
  				$scope.multiple = !$scope.unique;
  				return;
  			} 
  			var data = {};
  			data.json = newValue;
  			$.ajax({
  				type:"post",
  				url:"user/isUnique.action",
  				data:data,
  				success:function(data){
  					$scope.unique = JSON.parse(data.json);
  					$scope.multiple = !$scope.unique;
  					 $scope.$apply();//需要手动刷新 
  				},
  				error:function(){
  					$scope.unique = false;
  					$scope.multiple = !$scope.unique;
  					$scope.$apply();//需要手动刷新 
  				}
  			});
  		});
  		//提交
  		$scope.register = function(user){
  			if(user.username == ""){
  				alert("用户名不可为空！");
  				return;
  			}
  			if(user.pid == ""){
  				alert("所在部门不可为空！");
  				return;
  			}
  			if(user.password == "" || $scope.password == ""){
  				alert("密码不可为空！");
  				return;
  			}
  			if(user.password != $scope.password){
  				alert("两次输入的密码不一致！");
  				return;
  			}
  			var data = {};
  			data.json = JSON.stringify(user);
  			$.ajax({
  				type:"post",
  				url:"add.action",
  				async:true,
  				data:data,
  				success:function(data){
  					var data = JSON.parse(data.json);
  					if(data.status){
  						alert("注册成功！");
  						location.href = "login.jsp";
  					}
  				},
  				error:function(data){
  					alert("服务器错误！");
  				}
  				
  			});
  		}
}]);