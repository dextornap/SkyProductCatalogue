package com.sky.catalogue.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sky.catalogue.model.Product;

/**
 * Implementation of Product DAO Interface. <br>
 * 
 * Provides access to Product data in the database. Implements methods for CRUD
 * operations.
 * 
 * @see com.sky.catalogue.dao.ProductDao
 * 
 * @author Ranjan Lal
 *
 */
@Component
public class ProductDaoImpl implements ProductDao {

	/**
	 * Map containing Product data (In-memory data store). Injected via Spring
	 * Auto Wiring.
	 */
	@Resource(name = "products")
	private Map<String, Product> products;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.dao.ProductDao#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = new ArrayList<>(products.values());
		return Collections.unmodifiableList(allProducts);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sky.catalogue.dao.ProductDao#getProductById(java.lang.String)
	 */
	@Override
	public Product getProductById(String productId) {
		Product product = products.get(productId);
		if (product == null) {
			throw new RuntimeException("Could not find Product with id = " + productId);
		}
		return product;
	}

}
