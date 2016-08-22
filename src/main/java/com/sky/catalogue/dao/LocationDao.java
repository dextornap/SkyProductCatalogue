package com.sky.catalogue.dao;

import java.util.List;

import com.sky.catalogue.model.Location;

/**
 * Interface for Location DAO. <br>
 * 
 * Provides methods for CRUD operations to work on Location database table. <br>
 * For Sky Product Catalogue requirements the data is maintained in-memory.
 * 
 * @author Ranjan Lal
 *
 */
public interface LocationDao {

	/**
	 * Fetches all locations stored in the database.
	 * 
	 * @return List of Location objects retrieved from database.
	 */
	List<Location> getAllLocations();

	/**
	 * Fetches a Location from database for a given id.
	 * 
	 * @param locationId
	 *            Location id
	 * @return Location object retrieved from database
	 */
	Location getLocationById(String locationId);

}
