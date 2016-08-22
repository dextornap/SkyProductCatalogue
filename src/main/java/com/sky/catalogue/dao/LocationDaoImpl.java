package com.sky.catalogue.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sky.catalogue.model.Location;

/**
 * Implementation of Location DAO Interface. <br>
 * 
 * Provides access to Location data in the database. Implements methods for CRUD
 * operations.
 * 
 * @see com.sky.catalogue.dao.LocationDao
 * 
 * @author Ranjan Lal
 *
 */
@Component
public class LocationDaoImpl implements LocationDao {

	/**
	 * Map containing Location data (In-memory data store). Injected via Spring
	 * Auto Wiring.
	 */
	@Resource(name = "locations")
	private Map<String, Location> locations;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.dao.LocationDao#getAllLocations()
	 */
	@Override
	public List<Location> getAllLocations() {
		List<Location> allLocations = new ArrayList<>(locations.values());
		return Collections.unmodifiableList(allLocations);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.dao.LocationDao#getLocationById(java.lang.String)
	 */
	@Override
	public Location getLocationById(String locationId) {
		Location location = locations.get(locationId);
		if (location == null) {
			throw new RuntimeException("Could not find Location with id = " + locationId);
		}
		return location;
	}

}
