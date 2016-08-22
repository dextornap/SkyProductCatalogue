'use strict';

angular.module('skyProductCatalogueApp').controller('SubscriptionController', ['$scope', '$routeParams', 'CatalogueService', function($scope, $routeParams, CatalogueService) {
	
	$scope.customerId = $routeParams.customerId;
	$scope.locationId = CatalogueService.getBasketLocationId();
	$scope.basket = CatalogueService.getBasketProducts();

}]);
