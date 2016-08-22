package com.sky.catalogue.dao;

import java.util.List;

import com.sky.catalogue.model.Customer;

/**
 * Interface for Customer DAO. <br>
 * 
 * Provides methods for CRUD operations to work on Customer database table. <br>
 * For Sky Product Catalogue requirements the data is maintained in-memory.
 * 
 * @author Ranjan Lal
 *
 */
public interface CustomerDao {

	/**
	 * Fetches all customers stored in the database.
	 * 
	 * @return List of Customer objects retrieved from database.
	 */
	List<Customer> getAllCustomers();

	/**
	 * Fetches a Customer from database for a given id.
	 * 
	 * @param customerId
	 *            Customer id
	 * @return Customer object retrieved from database
	 */
	Customer getCustomerById(String customerId);

}
