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

import com.sky.catalogue.dao.LocationDao;
import com.sky.catalogue.model.Location;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Location DAO
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class LocationDaoTest extends AbstractTestNGSpringContextTests {

	/**
	 * Location DAO object. Injected via Spring Auto Wiring.
	 */
	@Autowired
	private LocationDao locationDao;

	/**
	 * Test to check if all locations stored in database can be fetched through
	 * Location DAO.
	 * 
	 */
	@Test
	public void testGetAllLocations() {

		List<Location> allLocations = locationDao.getAllLocations();

		assertEquals(allLocations.size(), 2);

	}

	/**
	 * Test to check if a location with given Id can be fetched through Location
	 * DAO.
	 */
	@Test
	public void testGetLocationById() {

		Location location = locationDao.getLocationById("LVPL");

		assertNotNull(location);
		assertEquals(location.getLocationName(), "LIVERPOOL");
		assertEquals(location.getProducts().size(), 1);

	}

	/**
	 * Test to check if a location with given id does not exist in database.
	 *
	 */
	@Test(expectedExceptions = { RuntimeException.class })
	public void testLocationNotFoundInDatabase() {
		locationDao.getLocationById("ZZZP");
	}

}
