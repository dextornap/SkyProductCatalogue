package com.sky.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sky.catalogue.model.Customer;
import com.sky.catalogue.model.Location;
import com.sky.catalogue.model.Product;
import com.sky.catalogue.service.CatalogueService;
import com.sky.catalogue.service.CustomerService;
import com.sky.catalogue.service.LocationService;

/**
 * Spring Rest controller for APIs URL serving resource requests for Location,
 * Customer and Catalogue
 * 
 * @author Ranjan Lal
 *
 */
@RestController
@RequestMapping(value = "/services")
public class SkyProductCatalogueRestController {

	@Autowired
	LocationService locationService;
	@Autowired
	CustomerService customerService;
	@Autowired
	CatalogueService catelogueService;

	/**
	 * REST api to retrieve All Locations
	 * 
	 * @return Entity containing list of all locations available
	 */
	@RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Location>> listAllLocations() {

		List<Location> locations = locationService.findAllLocations();

		if (locations.isEmpty()) {
			return new ResponseEntity<List<Location>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}

	/**
	 * REST api to retrieve a Single Location
	 * 
	 * @return Entity containing a location for given location id
	 */
	@RequestMapping(value = "/locations/{locationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getLocation(@PathVariable("locationId") String locationId) {

		Location location = locationService.findLocationById(locationId);

		if (location == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}

	/**
	 * REST api to retrieve All Customers
	 * 
	 * @return Entity containing list of all customers available
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> listAllCustomers() {

		List<Customer> customers = customerService.findAllCustomers();

		if (customers.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	/**
	 * REST api to retrieve a Single Customer
	 * 
	 * @return Entity containing a customer with given customer id
	 */
	@RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") String customerId) {

		Customer customer = customerService.findCustomerById(customerId);

		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	/**
	 * REST api to retrieve Products available at a given Location
	 * 
	 * @return Entity containing list of products available at a given Location
	 *         with given location id
	 */
	@RequestMapping(value = "/products/locations/{locationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProductsForLocation(@PathVariable("locationId") String locationId) {

		List<Product> products = catelogueService.getProductsForLocation(locationId);

		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}