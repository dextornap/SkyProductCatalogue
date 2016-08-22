package com.sky.catalogue.model;

import java.util.List;

import com.sky.catalogue.model.constants.ProductCategory;

/**
 * @author Ranjan Lal
 *
 */
public class Product {

	private String productId;
	private String productName;
	private ProductCategory category;
	private List<String> locations;

	public Product() {
		super();
	}

	public Product(String productId, String productName, ProductCategory category, List<String> locations) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.locations = locations;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

}
