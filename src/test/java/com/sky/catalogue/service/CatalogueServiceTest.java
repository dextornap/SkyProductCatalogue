package com.sky.catalogue.service;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.sky.catalogue.model.Product;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Catalogue Service
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class CatalogueServiceTest extends AbstractTestNGSpringContextTests {

	/**
	 * atalogue Service object. Injected via Spring Auto Wiring.
	 */
	@Autowired
	private CatalogueService catalogueService;

	/**
	 * Test to check if a list of products available in a location with given
	 * location Id can be fetched from database
	 */
	@Test
	public void testGetProductsForLocationById() {

		List<Product> products = catalogueService.getProductsForLocation("LVPL");

		assertEquals(products.size(), 3);

	}

	/**
	 * Test to check if catalogue service returns an exception when given
	 * location id is invalid/not found in database
	 */
	@Test(expectedExceptions = { RuntimeException.class })
	public void testProductNotFoundInDatabase() {
		catalogueService.getProductsForLocation("ZZZP");
	}

}
