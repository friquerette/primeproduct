var myApp = angular.module('myApp', ['ngRoute']);

myApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
    when('/login', {
      templateUrl: '/primejs/static/views/login.html',
      controller: 'RegistrationController'
    }).
    when('/register', {
      templateUrl: '/primejs/static/views/register.html',
      controller: 'RegistrationController'
    }).
    when('/success', {
      templateUrl: '/primejs/static/views/success.html',
      controller: 'SuccessController'
    }).
    otherwise({
      redirectTo: '/login'
    });
}]);