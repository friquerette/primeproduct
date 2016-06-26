var myApp = angular.module('myApp', [ 'ngRoute' ]);

myApp.controller('CurrencyController', [ '$scope','$http', function($scope, $http) {
	var self = this;
	$http.get('/primejs/rest/currency/public/id').then(function(response) {
		$scope.dataId = response.data;
	})
	$http.get('/primejs/rest/currency/public/currenciesList').then(function(response) {
		$scope.currencies = response.data;
	})
	$scope.message = "Success 5!!!";
} ]);