package com.sky.catalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.catalogue.dao.LocationDao;
import com.sky.catalogue.dao.ProductDao;
import com.sky.catalogue.model.Product;

/**
 * Catalogue Service implementation. <br>
 * Provides operations for finding Catalogue data from database.
 * 
 * @see com.sky.catalogue.service.CatalogueService
 * 
 * @author Ranjan Lal
 *
 */
@Service("productCatalogueService")
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private LocationDao locationDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sky.catalogue.service.CatalogueService#getProductsForLocation(java.
	 * lang.String)
	 */
	@Override
	public List<Product> getProductsForLocation(String locationId) {

		// first try to fetch a location with given id
		// throw an exception if location not found for given id
		try {
			locationDao.getLocationById(locationId);
		} catch (Exception e) {
			throw e;
		}

		// location with given id is available
		// now filter the products that belong to given location
		List<Product> allProducts = productDao.getAllProducts();

		List<Product> filteredProducts = new ArrayList<>();
		for (Product product : allProducts) {
			List<String> locations = product.getLocations();
			// products not assigned to a particular location are available at
			// all locations
			// so include them as well in final filtered list of products
			if (locations.isEmpty() || locations.contains(locationId)) {
				filteredProducts.add(product);
			}
		}

		return filteredProducts;
	}

}
