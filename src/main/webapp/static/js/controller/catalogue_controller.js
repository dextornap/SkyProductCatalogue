'use strict';

angular.module('skyProductCatalogueApp').controller('CatalogueController', ['$scope', '$cookies', '$location', 'CatalogueService', function($scope, $cookies, $location, CatalogueService) {
	
    $scope.fetchSubscriptionData = fetchSubscriptionData;
    $scope.addProductToBasket = addProductToBasket;
    $scope.checkout = checkout;
    
    $cookies.customerId = 'MP';
    $scope.customerId = $cookies.customerId;
    
    fetchSubscriptionData();
    
    function fetchSubscriptionData() {
    	fetchLocationForCustomer($scope.customerId);
    }
    
    function fetchLocationForCustomer(customerId) {
    	 
    	 $scope.basket = [];
    	 
    	 CatalogueService.fetchLocationForCustomer(customerId)
	        .then(
	        function(customer) {
	        	$scope.customer = customer;
	            $scope.locationId = customer.locationId;
	            fetchProductsForLocation(customer.locationId);
	        }
	        ,
	        function(errResponse){
	            console.error('Error while fetching Customer with id : ' + customerId);
	        }
	    );
    }
    
    
    function fetchProductsForLocation(locationId) {
    	
    	CatalogueService.fetchProductsForLocation(locationId)
        .then(
        function(products) {
            
            var sportsProducts = [];
            var newsProducts = [];
            var j=0;
            var k=0;
            for(var i = 0; i < products.length; i++){
            	switch(products[i].category) {
	            	case 'SPORTS': 
	            		sportsProducts[j++] = products[i];
	            		break
	            	case 'NEWS':
	            		newsProducts[k++] = products[i];
	            		break;
	            	default:
	            			break;
            	}
            }
            
            $scope.sportsProducts = sportsProducts;
            $scope.newsProducts = newsProducts; 
            
        },
        function(errResponse){
            console.error('Error while fetching Products for location id : ' + locationId);
        }
        );
    	
    }
    
    
    function addProductToBasket($event, product) {
    	
    	var checkbox = $event.target;
    	var basket = $scope.basket;
    	
    	if(checkbox.checked) {
    		basket.push(product);
    	} else {
	    	var index = basket.indexOf(product);
	    	if(index != -1) {
	    		basket.splice(index, 1);
	    	}
    	}
    	
    	$scope.showCheckoutButton = (basket.length > 0 ? true : false);;
    	
    }
    
    function checkout() {
    	
    	CatalogueService.setBasketLocationId($scope.locationId);
    	CatalogueService.setBasketProducts($scope.basket);

    	$location.path('/subscriptions/' + $scope.customerId);
    }
    
}]);
