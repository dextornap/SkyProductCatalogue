package com.sky.catalogue.service;

import java.util.List;

import com.sky.catalogue.model.Location;

/**
 * Interface for Location Service <br>
 * 
 * Provides operations for finding Location data from database.
 * 
 * @author Ranjan Lal
 *
 */
public interface LocationService {

	/**
	 * Finds all available locations in database.
	 * 
	 * @return List of Location objects retrieved from DB
	 */
	List<Location> findAllLocations();

	/**
	 * Fetches a location data for given location id
	 * 
	 * @param locationId
	 *            Location Id
	 * 
	 * @return Location object retrieved from DB
	 */
	Location findLocationById(String locationId);

}
