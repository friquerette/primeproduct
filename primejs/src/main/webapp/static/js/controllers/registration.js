myApp.controller('RegistrationController', [ '$scope', '$http', function($scope, $http) {

	$scope.login = function() {
		var self = this;
		$http.get('/primejs/rest/currency/public/id').then(function(response) {
			$scope.dataId = response.data;
		})
		alert($scope.dataId);
		$scope.message = "Welcome " + $scope.user.email;
	};
	$scope.register = function() {
		$scope.message = "Welcome " + $scope.user.firstname;
	};

} ]);