package com.sky.catalogue.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.sky.catalogue.model.Customer;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Customer Service
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class CustomerServiceTest extends AbstractTestNGSpringContextTests {

	/**
	 * Customer Service object. Injected via Spring Auto Wiring.
	 */
	@Autowired
	private CustomerService customerService;

	/**
	 * Test to check if all customers stored in database can be fetched through
	 * Customer Service.
	 * 
	 */
	@Test
	public void testGetAllCustomers() {

		List<Customer> allCustomers = customerService.findAllCustomers();

		assertEquals(allCustomers.size(), 2);

	}

	/**
	 * Test to check if a customer with given Id can be fetched through Customer
	 * Service.
	 */
	@Test
	public void testGetCustomerById() {

		Customer customer = customerService.findCustomerById("JL");

		assertNotNull(customer);
		assertEquals(customer.getLocationId(), "LNDN");

	}

	/**
	 * Test to check if a customer with given Id does not exist in database.
	 *
	 */
	@Test(expectedExceptions = { RuntimeException.class })
	public void testCustomerNotFoundInDatabase() {
		customerService.findCustomerById("ZZZP");
	}

}
