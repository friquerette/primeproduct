var myApp = angular.module('myApp', ['ngRoute']);

myApp.controller('SuccessController', ['$scope', function($scope) {
	  $scope.message = "Success!!!";
	}]);