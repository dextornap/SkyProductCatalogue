package com.sky.catalogue.dao;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.sky.catalogue.dao.ProductDao;
import com.sky.catalogue.model.Product;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Product DAO
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class ProductDaoTest extends AbstractTestNGSpringContextTests {

	/**
	 * Product DAO object. Injected via Spring Auto Wiring.
	 */
	@Autowired
	private ProductDao productDao;

	/**
	 * Test to check if all products stored in database can be fetched through
	 * Customer DAO.
	 * 
	 */
	@Test
	public void testGetAllProducts() {

		List<Product> allProducts = productDao.getAllProducts();

		assertEquals(allProducts.size(), 5);

	}

	/**
	 * Test to check if a product with given Id can be fetched through product
	 * DAO.
	 */
	@Test
	public void testGetProductById() {

		Product product = productDao.getProductById("ARSNLTV");

		assertNotNull(product);
		assertEquals(product.getProductName(), "Arsenal TV");
		assertEquals(product.getLocations().size(), 1);

	}

	/**
	 * Test to check if a product with given id does not exist in database.
	 *
	 */
	@Test(expectedExceptions = { RuntimeException.class })
	public void testProductNotFoundInDatabase() {
		productDao.getProductById("ZZZP");
	}

}
