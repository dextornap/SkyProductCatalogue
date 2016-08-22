package com.sky.catalogue.dao;

import java.util.List;

import com.sky.catalogue.model.Product;

/**
 * Interface for Product DAO. <br>
 * 
 * Provides methods for CRUD operations to work on Product database table. <br>
 * For Sky Product Catalogue requirements the data is maintained in-memory.
 * 
 * @author Ranjan Lal
 *
 */
public interface ProductDao {

	/**
	 * Fetches all products stored in the database.
	 * 
	 * @return List of Product objects retrieved from database.
	 */
	List<Product> getAllProducts();

	/**
	 * Fetches a Product from database for a given id.
	 * 
	 * @param productId
	 *            Product id
	 * @return Product object retrieved from database
	 */
	Product getProductById(String productId);

}
