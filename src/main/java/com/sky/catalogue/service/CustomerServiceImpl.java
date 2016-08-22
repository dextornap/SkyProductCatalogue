package com.sky.catalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.catalogue.dao.CustomerDao;
import com.sky.catalogue.model.Customer;

/**
 * Customer Service implementation. <br>
 * Provides operations for finding Location data from database.
 * 
 * @see com.sky.catalogue.service.CustomerService
 * 
 * @author Ranjan Lal
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.service.CustomerService#findAllCustomers()
	 */
	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.getAllCustomers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sky.catalogue.service.CustomerService#findCustomerById(java.lang.
	 * String)
	 */
	@Override
	public Customer findCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}

}
