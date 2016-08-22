# SKY Product Catalogue Service
A web application serving product catalog services to subscribe for channels provided by Sky.
This is a single page web application providing all services for product/channel catalog and subscription for a customer based on his/her location.

## Technologies involved

### Front-end
	HTML5, CSS, AngularJS
	
### Back-end
	Spring 4

### Unit Testing
	TestNG

## IDE
	Eclipse

## How to use

	This is a maven project. This can be tested using the Unit tests included. 
	* mvn test -> to execute the unit tests  
	
	This can be packaged as a WAR :
	* mvn package -> to generate the WAR
	
	The WAR can be deployed to a web server (e.g Tomcat)
	
	Access the web application at:
		http://<host>:<port>/SkyProductCatalogue
	
	REST APIs (web services) provided:
	
		1. 	http://<host>:<port>/SkyProductCatalogue/services/locations
			Retrieves All Locations available
			
		2. http://<host>:<port>/SkyProductCatalogue/services/locations/{locationId}
			Retrieves a Single Location for given location id
		
		3. http://<host>:<port>/SkyProductCatalogue/services/customers
			Retrieves All Customers registered 
		
		4. http://<host>:<port>/SkyProductCatalogue/services/customers/{customerId}
			Retrieves a Single Customer for given customer id
		
		5. http://<host>:<port>/SkyProductCatalogue/services/products/locations/{locationId}
			Retrieves all Products available at a given Location
	

## Solution Design

#### 3-Tier Architecture
	
The application tries to follow the standard 3 Tier JEE architecture. Presentation layer is implemented using AngularJS. The Service layer and the DAO layer implemented with Spring 4. All data is held in memory. No database is used. A simple data store is created using Maps. 

The design is flexible and extensible. It can be used as a web application, or can be published as RESTful web service to be consumed by external systems.


## Implementation 

#### Project Management / Build Framework

The project was planned to be implemented as a web application. I chose Maven for its easy project management and build capabilities. I started off with creating a maven project integrated in Eclipse IDE with archetype as - "maven-archetype-webapp".

#### Application Framework

The application must follow OO Principles. To implement a cohesive and loosely coupled structure (Trying to follow SOLID principles) I chose to use Spring Framework for the Application context and Dependency Injection. Added Spring 4 dependencies in Maven POM.xml 

#### Unit Test Framework

Trying to follow TDD approach I chose to use TestNG framework as it provides many features to make testing more powerful and easier to do. Added TestNG dependencies in POM.xml. Created a testng.xml file to create a test suite to include all my test classes. Configured path to testng.xml (src/test/java/resources) in POM file using maven-surefire-plugin.

### Apllication workflow

1. When the user visits the product selection page, a cookie named customerID is present, which holds a customer identifier. Also the page provides a text box that is initialized with the customer ID from the cookie. But that also allows for the user to input another customer ID (for a customer already registered). To find the list of all customers available in the system, the following REST api can be invoked:

http://<host>:<port>/SkyProductCatalogue/services/customers

2. When the customer selects or unselects a product, the basket is updated to show the selected products.

3. When the customer chooses to checkout, the customer is taken to the confirmation page.

4. When the customer chooses to checkout, the customer’s customerID and list of selected products are posted to the confirmation page.



