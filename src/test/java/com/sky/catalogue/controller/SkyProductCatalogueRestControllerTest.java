package com.sky.catalogue.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Sky Product Catalogue Rest Controller
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class SkyProductCatalogueRestControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		// MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}

	/**
	 * Test to check if the REST api returns all locations data from the database
	 * 
	 * @throws Exception
	 */
	@Test
	public void testListAllLocations() throws Exception {

		this.mockMvc.perform(get("/services/locations")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
	}

	/**
	 * Test to check if the REST api returns a location data for given Id from the database
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetLocation() throws Exception {

		this.mockMvc.perform(get("/services/locations/LNDN")).andExpect(status().isOk())
				.andExpect(jsonPath("$.locationName", is("LONDON"))).andExpect(jsonPath("$.products", hasSize(2)));
	}

	/**
	 * Test to check if the REST api returns all Customers data from the database
	 * 
	 * @throws Exception
	 */
	@Test
	public void testListAllCustomers() throws Exception {

		this.mockMvc.perform(get("/services/customers")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
	}

	
	/**
	 * Test to check if the REST api returns a Customer data for given Id from the database
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetCustomer() throws Exception {

		this.mockMvc.perform(get("/services/customers/MP")).andExpect(status().isOk())
				.andExpect(jsonPath("$.locationId", is("LVPL")));
	}
	
	/**
	 * Test to check if the REST api returns a list of products available in a location for given location idF
	 *  
	 * @throws Exception
	 */
	@Test
	public void testGetProductsForLocation() throws Exception {

		this.mockMvc.perform(get("/services/products/locations/LNDN")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(4)));
	}
}
