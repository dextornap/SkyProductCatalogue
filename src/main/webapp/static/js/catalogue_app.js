'use strict';

var App = angular.module('skyProductCatalogueApp', ['ngRoute', 'ngCookies']);

App.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'pages/CatalogueTemplate',
		controller : 'CatalogueController'
	}).when('/subscriptions/:customerId', {
		templateUrl : 'pages/ConfirmationTemplate',
		controller : 'SubscriptionController'
	}).otherwise({
		redirectTo : '/'
	});
}]);
