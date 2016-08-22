package com.sky.catalogue.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sky.catalogue.model.Customer;

/**
 * Implementation of Customer DAO Interface. <br>
 * 
 * Provides access to Customer data in the database. Implements methods for CRUD
 * operations.
 * 
 * @see com.sky.catalogue.dao.CustomerDao
 * 
 * @author Ranjan Lal
 *
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

	/**
	 * Map containing Customer data (In-memory data store). Injected via Spring
	 * Auto Wiring.
	 */
	@Resource(name = "customers")
	private Map<String, Customer> customers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.dao.CustomerDao#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = new ArrayList<>(customers.values());
		return Collections.unmodifiableList(allCustomers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.dao.CustomerDao#getCustomerById(java.lang.String)
	 */
	@Override
	public Customer getCustomerById(String customerId) {
		Customer customer = customers.get(customerId);
		if (customer == null) {
			throw new RuntimeException("Could not find customer with id = " + customerId);
		}
		return customer;
	}

}
