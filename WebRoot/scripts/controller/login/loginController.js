app.controller("loginController",["$scope","$http",function($scope,$http){
		$scope.login = function(user){
			$.ajax({
				url:  'login.action',
				type: 'POST',
				data: {"json":JSON.stringify(user)},
				success:function(data){
					var data = JSON.parse(data.json);
					if(data.status){
						alert(data.message);
					}else{
					
						location.href="index.jsp";
					}
				},
				error:function(errror){
					alert("服务器错误！");
				}
			});
		}

}]);
