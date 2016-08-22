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

import com.sky.catalogue.model.Location;

import config.SkyProductCatalogueTestConfiguration;

/**
 * 
 * TestNG Unit Test class for Location Service
 * 
 * @author Ranjan Lal
 *
 */
@Test
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {
		SkyProductCatalogueTestConfiguration.class })
public class LocationServiceTest extends AbstractTestNGSpringContextTests {

	/**
	 * Location Service object. Injected via Spring Auto Wiring.
	 */
	@Autowired
	private LocationService locationService;

	/**
	 * Test to check if all locations stored in database can be fetched through
	 * service interface.
	 * 
	 */
	@Test
	public void testGetAllLocations() {

		List<Location> allLocations = locationService.findAllLocations();

		assertEquals(allLocations.size(), 2);

	}

	/**
	 * Test to check if a location for given Id can be fetched
	 */
	@Test
	public void testGetLocationById() {

		Location location = locationService.findLocationById("LVPL");

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
		locationService.findLocationById("ZZZP");
	}

}
