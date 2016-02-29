app.directive('ensureUnique', ['$http', function($http) {
  return {
    require: 'ngModel',
    link: function(scope, ele, attrs, c) {
    	console.log(scope)
    	console.log(ele)
    	console.log(attrs)
    	console.log(c)
      scope.$watch(attrs.ngModel, function() {
       /* $http({
          method: 'POST',
          url: 'user/isUnique.action',
          data: {'json': attrs.ensureUnique}
        }).success(function(data, status, headers, cfg) {
        	var flag = JSON.parse(data.json);
          c.$setValidity('unique', flag);
        }).error(function(data, status, headers, cfg) {
          c.$setValidity('unique', false);
        });*/
       var data = {};
       data.json = attrs.ensureUnique;
       console.log(data)
       $.ajax({
  				type:"post",
  				url:"user/isUnique.action",
  				async:true,
  				data:data,
  				success:function(data){debugger;
  					var flag = JSON.parse(data.json);
          			c.$setValidity('unique', flag);
  				},
  				error:function(data){
  					c.$setValidity('unique', false);
  				}
  			});
      });
    }
  }
}]);