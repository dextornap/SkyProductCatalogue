package com.sky.catalogue.model.constants;

/**
 * @author Ranjan Lal
 *
 */
public enum ProductCategory {

	SPORTS("Sports"), NEWS("News");

	private String value;

	private ProductCategory(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
