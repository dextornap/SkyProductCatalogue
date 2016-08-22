package config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sky.catalogue.model.Customer;
import com.sky.catalogue.model.Location;
import com.sky.catalogue.model.Product;
import com.sky.catalogue.model.constants.ProductCategory;

/**
 * 
 * Spring Java context configuration for TestNG unit tests.
 * 
 * @author Ranjan Lal
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.sky.catalogue")
public class SkyProductCatalogueTestConfiguration {

	/**
	 * Creates Spring Bean to represent an in-memory database table to hold
	 * Location Data. Initialized with sample data to be used in unit tests.
	 * 
	 * @return Map representing Location data.
	 */
	@Bean(name = "locations")
	public Map<String, Location> getLocationsData() {
		Map<String, Location> locations = new ConcurrentHashMap<>();
		locations.put("LNDN",
				new Location("LNDN", "LONDON", "Kings Cross, London", Arrays.asList("ARSNLTV", "CHLSEATV")));
		locations.put("LVPL", new Location("LVPL", "LIVERPOOL", "Albert Dock, Liverpool", Arrays.asList("LVRPLTV")));
		return locations;
	}

	/**
	 * Creates Spring Bean to represent an in-memory database table to hold
	 * Customer Data. Initialized with sample data to be used in unit tests.
	 * 
	 * @return Map representing Customer data.
	 */
	@Bean(name = "customers")
	public Map<String, Customer> getCustomersData() {
		Map<String, Customer> customers = new ConcurrentHashMap<>();
		customers.put("JL", new Customer("JL", "James Lewis", "011-22898988", "LNDN"));
		customers.put("MP", new Customer("MP", "Mathew Pike", "011-22928355", "LVPL"));
		return customers;
	}

	/**
	 * Creates Spring Bean to represent an in-memory database table to hold
	 * Product Data. Initialized with sample data to be used in unit tests.
	 * 
	 * @return Map representing Product data.
	 */
	@Bean(name = "products")
	public Map<String, Product> getProductsData() {
		Map<String, Product> products = new ConcurrentHashMap<>();
		products.put("ARSNLTV", new Product("ARSNLTV", "Arsenal TV", ProductCategory.SPORTS, Arrays.asList("LNDN")));
		products.put("CHLSEATV", new Product("CHLSEATV", "Chelsea TV", ProductCategory.SPORTS, Arrays.asList("LNDN")));
		products.put("LVRPLTV", new Product("LVRPLTV", "Liverpool TV", ProductCategory.SPORTS, Arrays.asList("LVPL")));
		products.put("SKYNEWS", new Product("SKYNEWS", "Sky News", ProductCategory.NEWS, new ArrayList<String>()));
		products.put("SKYSPRTNEWS",
				new Product("SKYSPRTNEWS", "Sky Sports News", ProductCategory.NEWS, new ArrayList<String>()));
		return products;
	}

}
