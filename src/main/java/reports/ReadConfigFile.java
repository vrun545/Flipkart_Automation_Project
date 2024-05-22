package reports;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadConfigFile {
	
	Properties properties;
	String path = "C:\\Users\\varunbajpai\\eclipse-workspace\\FlipkartTesting\\src\\main\\resources\\Properties\\Config.properties";

//	Basic Setup for Reading Config File
	public ReadConfigFile() {
		properties = new Properties();
		try {
		FileInputStream fis = new FileInputStream(path);
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		} 
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
//	This function return Base-URL
	public String getURL() {
		String URL = properties.getProperty("url");
		if (URL != null)
			return URL;
		else
			throw new RuntimeException("URL not found in Config File");
	}
	
//	This function returns API-Key
	public String getAPI_KEY() {
		String API_KEY = properties.getProperty("API_KEY");
		if (API_KEY != null)
			return API_KEY;
		else
			throw new RuntimeException("API-KEY not found in Config File");
	}

//	This function returns Server-ID
	public String getServerID() {
		String serverId = properties.getProperty("serverId");
		if (serverId != null)
			return serverId;
		else
			throw new RuntimeException("Server-ID not found in Config File");
	}
	
	
//	This function returns Server Domain
	public String getServerDomain() {
		String serverDomain = properties.getProperty("serverDomain");
		if (serverDomain != null)
			return serverDomain;
		else
			throw new RuntimeException("Server-Domain not found in Config File");
	}
	
	
//	This function returns Server Domain
	public String getEmail() {
		String email = properties.getProperty("email");
		if (email != null)
			return email;
		else
			throw new RuntimeException("Email not found in Config File");
	}
	
//	This function return product name
	public String getProduct() {
		String product = properties.getProperty("product");
		if (product != null)
			return product;
		else
			throw new RuntimeException("Product not found in Config File");
	}
	
//	This function return pincode name
	public String getPincode() {
		String pincode = properties.getProperty("pincode");
		if (pincode != null)
			return pincode;
		else
			throw new RuntimeException("Pincode not found in Config File");
	}
	
//	This function return departureCity name
	public String getDepCity() {
		String departureCity = properties.getProperty("departureCity");
		if (departureCity != null)
			return departureCity;
		else
			throw new RuntimeException("departureCity not found in Config File");
	}
	
//	This function return arrivalCity name
	public String getArrCity() {
		String arrivalCity = properties.getProperty("arrivalCity");
		if (arrivalCity != null)
			return arrivalCity;
		else
			throw new RuntimeException("arrivalCity not found in Config File");
	}
	
//	This function return City name
	public String getCity() {
		String city = properties.getProperty("city");
		if (city != null)
			return city;
		else
			throw new RuntimeException("city not found in Config File");
	}
	
//	This function return Flight Section link
	public String getFlightLink() {
		String flightLink = properties.getProperty("flightLink");
		if (flightLink != null)
			return flightLink;
		else
			throw new RuntimeException("flightLink not found in Config File");
	}
	
//	This function return Product link
	public String getProductLink() {
		String productLink = properties.getProperty("productLink");
		if (productLink != null)
			return productLink;
		else
			throw new RuntimeException("productLink not found in Config File");
	}
	
//	This function return Filter Section link
	public String getFilterLink() {
		String filterLink = properties.getProperty("filterLink");
		if (filterLink != null)
			return filterLink;
		else
			throw new RuntimeException("filterLink not found in Config File");
	}
	
	
//	This function return Grocery Section link
	public String getGroceryLink() {
		String groceryLink = properties.getProperty("groceryLink");
		if (groceryLink != null)
			return groceryLink;
		else
			throw new RuntimeException("groceryLink not found in Config File");
	}
	
//	This function return Login link
	public String getLoginLink() {
		String loginURL = properties.getProperty("loginURL");
		if (loginURL != null)
			return loginURL;
		else
			throw new RuntimeException("loginURL not found in Config File");
	}
	
	
//	This function return Register link
	public String getRegisterLink() {
		String registerLink = properties.getProperty("registerLink");
		if (registerLink != null)
			return registerLink;
		else
			throw new RuntimeException("registerLink not found in Config File");
	}
	
	
//	This function return Phone number
	public String getPhoneNo() {
		String PhoneNo = properties.getProperty("PhoneNo");
		if (PhoneNo != null)
			return PhoneNo;
		else
			throw new RuntimeException("PhoneNo not found in Config File");
	}
}
