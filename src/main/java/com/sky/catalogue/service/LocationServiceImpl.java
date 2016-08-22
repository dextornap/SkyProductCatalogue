package com.sky.catalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.catalogue.dao.LocationDao;
import com.sky.catalogue.model.Location;

/**
 * Location Service implementation. <br>
 * Provides operations for finding Location data from database.
 * 
 * @see com.sky.catalogue.service.LocationService
 * 
 * @author Ranjan Lal
 *
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.service.LocationService#findAllLocations()
	 */
	@Override
	public List<Location> findAllLocations() {
		return locationDao.getAllLocations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sky.catalogue.service.LocationService#findLocationById(java.lang.
	 * String)
	 */
	@Override
	public Location findLocationById(String locationId) {
		return locationDao.getLocationById(locationId);
	}

}
