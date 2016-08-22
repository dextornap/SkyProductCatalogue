package com.sky.catalogue.dao;

import static org.testng.Assert.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.sky.catalogue.dao.CustomerDao;
import com.sky.catalogue.model.Customer;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Customer DAO
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class CustomerDaoTest extends AbstractTestNGSpringContextTests {

	/**
	 * Customer DAO object. Injected via Spring Auto Wiring.
	 */
	@Autowired
	private CustomerDao customerDao;

	/**
	 * Test to check if all customers stored in database can be fetched through
	 * Customer DAO.
	 * 
	 */
	@Test
	public void testGetAllCustomers() {

		List<Customer> allCustomers = customerDao.getAllCustomers();

		assertEquals(allCustomers.size(), 2);

	}

	/**
	 * Test to check if a customer with given Id can be fetched through Customer
	 * DAO.
	 */
	@Test
	public void testGetCustomerById() {

		Customer customer = customerDao.getCustomerById("JL");

		assertNotNull(customer);
		assertEquals(customer.getLocationId(), "LNDN");

	}

	/**
	 * Test to check if a stock with given symbol does not exist in database.
	 *
	 */
	@Test(expectedExceptions = { RuntimeException.class })
	public void testCustomerNotFoundInDatabase() {
		customerDao.getCustomerById("ZZZP");
	}

}
