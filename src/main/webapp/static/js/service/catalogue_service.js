'use strict';

angular.module('skyProductCatalogueApp').factory('CatalogueService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SkyProductCatalogue/services/';
    var REST_CUSTOMER_SERVICE_URI = REST_SERVICE_URI + 'customers/';
    var REST_PRODUCTS_BY_LOCATION_SERVICE_URI = REST_SERVICE_URI + 'products/locations/';
    
    var self = this;
    self.basketProducts=[];
    self.basketLocationId;

    var factory = {
        fetchLocationForCustomer: fetchLocationForCustomer, 
        fetchProductsForLocation: fetchProductsForLocation,
        setBasketLocationId: setBasketLocationId,
        getBasketLocationId: getBasketLocationId,
        setBasketProducts: setBasketProducts,
        getBasketProducts: getBasketProducts        
    };

    return factory;
    
    function fetchLocationForCustomer(customerId) {
    	var deferred = $q.defer();
        $http.get(REST_CUSTOMER_SERVICE_URI + customerId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Customer with id : ' + customerId);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchProductsForLocation(locationId) {
    	var deferred = $q.defer();
        $http.get(REST_PRODUCTS_BY_LOCATION_SERVICE_URI + locationId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Products for location id : ' + locationId);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function setBasketProducts(products) {
    	self.basketProducts = products;
    } 
    
    function getBasketProducts() {
    	return self.basketProducts;
    }
    
    function setBasketLocationId(basketLocationId) {
    	self.basketLocationId = basketLocationId;
    } 
    
    function getBasketLocationId() {
    	return self.basketLocationId;
    }
    
}]);
