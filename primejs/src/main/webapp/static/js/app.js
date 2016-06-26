
var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "/primejs/static/views/login.html"
    })
    .when("/red", {
        templateUrl : "/primejs/static/views/nav.html"
    })
    .when("/green", {
        templateUrl : "/primejs/static/views/register.html"
    })
    .when("/blue", {
        templateUrl : "/primejs/static/views/success.html"
    });
});