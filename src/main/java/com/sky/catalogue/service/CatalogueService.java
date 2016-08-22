package com.sky.catalogue.service;

import java.util.List;

import com.sky.catalogue.model.Product;

/**
 * Interface for Catalogue Service <br>
 * 
 * Provides operations for finding Catalogue information from database.
 * 
 * @author Ranjan Lal
 *
 */
public interface CatalogueService {

	/**
	 * Fetches a list of products available in a location with given location Id
	 * 
	 * @param locationId
	 *            Location id
	 * @return List of Products available at given location
	 */
	List<Product> getProductsForLocation(String locationId);

}
