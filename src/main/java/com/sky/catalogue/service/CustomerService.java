package com.sky.catalogue.service;

import java.util.List;

import com.sky.catalogue.model.Customer;

/**
 * Interface for Customer Service <br>
 * 
 * Provides operations for finding Customer data from database.
 * 
 * @author Ranjan Lal
 *
 */
public interface CustomerService {

	/**
	 * Finds all available customers in database.
	 * 
	 * @return List of Customer objects retrieved from DB
	 */
	List<Customer> findAllCustomers();

	/**
	 * Fetches a customer data for given location id
	 * 
	 * @param customerId
	 *            Customer Id
	 * @return Customer object retrieved from DB
	 */
	Customer findCustomerById(String customerId);

}
