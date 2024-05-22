package tests;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mailosaur.MailosaurException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;
import reports.ExtentManager;
import reports.ReadConfigFile;
import utils.Utils;


public class Test_FlipkartSite {
	
	private static final Logger logger = LogManager.getLogger(Test_FlipkartSite.class);
	ReadConfigFile ConfigFile = new ReadConfigFile();
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;

//	Method for Initializing drivers 
    @BeforeTest
    @Parameters("browser")
    public void initializeDriver(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions headlessChromeOptions = new ChromeOptions();
                headlessChromeOptions.addArguments("--headless");
                driver = new ChromeDriver(headlessChromeOptions);
                break;
            default:
                System.out.println("Invalid browser specified!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extent = ExtentManager.getInstance();
	    extent.setSystemInfo("Browser", browser);
	    extent.setSystemInfo("OS", "Windows 11");
	    logger.info("\n\n------------New Logging Details Added Below--------------");
    }
    
    
//    This method executes test cases based on the provided test data.
    @Test(dataProvider = "testData")
    public void executeTestCase(String testCaseName, String executionRequired, ITestContext context) throws InterruptedException, IOException, MailosaurException {
        if (executionRequired.equalsIgnoreCase("Yes")) {
            switch (testCaseName) {
                case "getFlipkartSite":
                    context.setAttribute("testCaseName", "getFlipkartSite");
                    getFlipkartSite();
                    break;
                case "clickOnProduct":
                    context.setAttribute("testCaseName", "clickOnProduct");
                    clickOnProduct();
                    break;
                case "searchProduct":
                    context.setAttribute("testCaseName", "searchProduct");
                    searchProduct();
                    break;
                case "changingPinCode":
                    context.setAttribute("testCaseName", "changingPinCode");
                    changingPinCode();
                    break;
                case "checkProductImages":
                    context.setAttribute("testCaseName", "checkProductImages");
                    checkProductImages();
                    break;
                case "addToCart":
                    context.setAttribute("testCaseName", "addToCart");
                    addToCart();
                    break;
                case "placeOrder":
                    context.setAttribute("testCaseName", "placeOrder");
                    placeOrder();
                    break;
                case "sortProduct":
                    context.setAttribute("testCaseName", "sortProduct");
                    sortProduct();
                    break;
                case "applyPriceFilter":
                    context.setAttribute("testCaseName", "applyPriceFilter");
                    applyPriceFilter();
                    break;
                case "applyBrandFilter":
                    context.setAttribute("testCaseName", "applyBrandFilter");
                    applyBrandFilter();
                    break;
                case "applyRatingFilter":
                    context.setAttribute("testCaseName", "applyRatingFilter");
                    applyRatingFilter();
                    break;
                case "applyBatteryCapacityFilter":
                    context.setAttribute("testCaseName", "applyBatteryCapacityFilter");
                    applyBatteryCapacityFilter();
                    break;
                case "checkMenApparel":
                    context.setAttribute("testCaseName", "checkMenApparel");
                    checkMenApparel();
                    break;
                case "checkFurniture":
                    context.setAttribute("testCaseName", "checkFurniture");
                    checkFurniture();
                    break;
                case "checkOfferZone":
                    context.setAttribute("testCaseName", "checkOfferZone");
                    checkOfferZone();
                    break;
                case "checkGrocerySection":
                    context.setAttribute("testCaseName", "checkGrocerySection");
                    checkGrocerySection();
                    break;
                case "checkMyCart":
                    context.setAttribute("testCaseName", "checkMyCart");
                    checkMyCart();
                    break;
                case "checkFlights":
                    context.setAttribute("testCaseName", "checkFlights");
                    checkFlights();
                    break;
                case "registerUser":
                    context.setAttribute("testCaseName", "registerUser");
                    registerUser();
                    break;
                case "checkLogin":
                    context.setAttribute("testCaseName", "checkLogin");
                    checkLogin();
                    break;
                default:
                    System.out.println("Test case not found: " + testCaseName);
            }
        } else {
            System.out.println("Skipping test case: " + testCaseName);
        }
    }


//    This test case is for Launching Flipkart Site
 	public void getFlipkartSite() {
    	test = extent.createTest("getFlipkartSite", "This test case for launching the site");
        test.log(Status.INFO, "Launching Flipkart Site");
        logger.info("Launching Flipkart Site");
        String URL = ConfigFile.getURL();
 		driver.get(URL);	
 		// Assertion
 	    String currentURL = driver.getCurrentUrl();
 	    Assert.assertEquals(currentURL, URL, "URLs do not match");
 	}  
        
    
//    This test case for clicking a product on Homepage
    public void clickOnProduct() throws InterruptedException {
    	test = extent.createTest("checkProductClickHome", "This test case is for clicking a product on Homepage");
        test.log(Status.INFO, "This test case is for clicking a product on Homepage");
        logger.info("Clicking on a product on Homepage");
    	try {
        FlipkartClickProductHome pageFactory = new FlipkartClickProductHome(driver);
        boolean isProductClicked = pageFactory.clickOnProduct();        
        // Assertion
        Assert.assertTrue(isProductClicked, "Product was not clicked successfully");
    	}	
    	catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
    	}
    }
    
    
//  This test case is for searching a product on search-box
  	public void searchProduct() throws InterruptedException {
		test = extent.createTest("searchProduct", "This test case is for searching a product on search-box");
		test.log(Status.INFO, "This test case is for searching a product on search-box");
		logger.info("Searching a product on Search-Box");
  		try {
  			FlipkartSearchBox pageFactory = new FlipkartSearchBox(driver);
  			String product = ConfigFile.getProduct();
  			Thread.sleep(2000);
  			pageFactory.enterProductName(product);
  			pageFactory.clickSearchButton();
  			boolean isProductClicked = pageFactory.clickProduct();		
  			// Assertion
  	        Assert.assertTrue(isProductClicked, "Product was not clicked successfully");
  		} 
  		catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  }
  
  
 // This test case is for changing Pincode
  	public void changingPinCode() throws InterruptedException {
	    test = extent.createTest("changingPinCode", "This test case is for changing the pincode");
	    test.log(Status.INFO, "This test case is for changing the pincode");
	    logger.info("Changing the pincode");	        
  	    try {
  	        // Handle new tab
  	        String originalTab = Utils.handleNewTab(driver);
  	        
  	        // Perform actions on the new tab
  	        FlipkartChangePincode pageFactory = new FlipkartChangePincode(driver);
  	        String pincode = ConfigFile.getPincode();
  	        pageFactory.enterPincode(pincode);
  	        
  	        // Assertion
  	        String expectedText = "Delivery";
  	        String actualText = pageFactory.getExpectedText();
  	        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found: " + expectedText);
  	        
  	        // Switch back to previous tab  	        
  	        driver.switchTo().window(originalTab);
  	    } catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}
 
    
//  This test case is for chechking product images
    	public void checkProductImages() throws InterruptedException {
	        test = extent.createTest("checkProductImages", "This test case is for checking product images");
	        test.log(Status.INFO, "This test case is for checking product images");
	        logger.info("Iterating on product images");
    		try {
    	        String productLink = ConfigFile.getProductLink();
    	        driver.get(productLink);
    	        FlipkartCheckProductImages pageFactory = new FlipkartCheckProductImages(driver);
    	        boolean isSeen = pageFactory.iterateOverImages();
    	        // Assertion
    	        Assert.assertTrue(isSeen, "Images were not seen");

    	    } catch (Exception e) {
    	    	test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
    	        throw e;
    	    }
	    }
    
    	
// This test case is to Add Product to cart
   public void addToCart() throws InterruptedException {
	     test = extent.createTest("addToCart", "This test case is to Add Product to cart");
	     test.log(Status.INFO, "This test case is to Add Product to cart");
	     logger.info("Adding a mobile product into cart");
    	try {        
    	     FlipkartAddToCart pageFactory = new FlipkartAddToCart(driver);
    	     boolean isClicked = pageFactory.clickAddToCartButton();
    	     // Assertion
   	        Assert.assertTrue(isClicked, "Button was not clicked");
    	    } 
    	catch (Exception e) {
    	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
    	        throw e;
    	    }
    	}
    	

// This test case is to place order
    public void placeOrder() throws InterruptedException {
	     test = extent.createTest("placeOrder", "This test case is to place order");
	     test.log(Status.INFO, "This test case is to place order");
	     logger.info("Placing the order");
    	 try {   
    	      FlipkartPlaceOrder pageFactory = new FlipkartPlaceOrder(driver);
    	      pageFactory.clickOrderButton();
    	      boolean isClicked = pageFactory.enterEmail();
    	      Thread.sleep(1000);
    	      // Assertion
     	      Assert.assertTrue(isClicked, "Button was not clicked");

    	    } 
    	 catch (Exception e) {
    	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
    	        throw e;
    	    }
    	}
  
	
// This test case is to sort product based on price
	public void sortProduct() throws InterruptedException {
		test = extent.createTest("sortProduct", "This test case is to sort product based on price");
	    test.log(Status.INFO, "This test case is to sort product based on price");
	    logger.info("Sorting products from Low To High Prices");   
	    try { 
	        String filterLink = ConfigFile.getFilterLink();
	        driver.get(filterLink);
	        FlipkartSortFilter pageFactory = new FlipkartSortFilter(driver);
	        boolean isClicked = pageFactory.applySortLowToHigh();
	        // Assertion
   	        Assert.assertTrue(isClicked, "Button was not clicked");
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	        throw e;
	    }
	}

	  
//  This test case is to apply price filter
	  public void applyPriceFilter() throws InterruptedException {
          test = extent.createTest("applyPriceFilter" ,"This test case is to apply price filter");
          test.log(Status.INFO, "This test case is to apply price filter");
          logger.info("Applying the price filter on search results");
	      try {
	          FlipkartPriceFilters pageFactory = new FlipkartPriceFilters(driver);
	          boolean isClicked = pageFactory.priceTag();
	          // Assertion
     	      Assert.assertTrue(isClicked, "Button was not clicked");
	      } 
	      catch (Exception e) {
	          test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	          throw e;
	      }
	  }
  	  
  	  
 // This test case is to apply brand filter
  	public void applyBrandFilter() throws InterruptedException {
	    test = extent.createTest("applyBrandFilter", "This test case is to apply brand filter");
	    test.log(Status.INFO, "This test case is to apply brand filter");
	    logger.info("Applying the brand filter on search results");    
  	    try {
  	        FlipkartBrandFilters pageFactory = new FlipkartBrandFilters(driver);
  	        boolean isClicked = pageFactory.brandFilter();
  	        // Assertion
   	        Assert.assertTrue(isClicked, "Filter was not selected");
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	} 	
  	
  	
 // This test case is to apply rating filter
  	public void applyRatingFilter() throws InterruptedException {
	    test = extent.createTest("applyRatingFilter", "This test case is to apply rating filter");
	    test.log(Status.INFO, "This test case is to apply rating filter");
	    logger.info("Applying the rating filter on search results");    
  	    try {
  	        FlipkartRatingFilters pageFactory = new FlipkartRatingFilters(driver);
  	        boolean isClicked = pageFactory.ratingFilter();
  	        // Assertion
   	        Assert.assertTrue(isClicked, "Filter was not selected");
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}

    
  	// This test case is to apply Battery Capacity filter
  	public void applyBatteryCapacityFilter() throws InterruptedException {
	    test = extent.createTest("applyBatteryCapacityFilter", "This test case is to apply Battery Capacity filter");
	    test.log(Status.INFO, "This test case is to apply Battery Capacity filter");
	    logger.info("Applying the Battery Capacity filter on search results");    
  	    try {
  	        FlipkartBatteryFilter pageFactory = new FlipkartBatteryFilter(driver);
  	        boolean isClicked = pageFactory.selectBatteryCapacity();     
  	        // Assertion
   	        Assert.assertTrue(isClicked, "Filter was not selected");
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}
  	  
  	
 // This test case is to check Men jackets products
  	public void checkMenApparel() throws InterruptedException {
	    test = extent.createTest("checkMenApparel", "This test case is to check Men jackets products");
	    test.log(Status.INFO, "This test case is to check Men jackets products");
	    logger.info("Checking Men jacket products");
  	    try {      
  	        FlipkartMenApparel pageFactory = new FlipkartMenApparel(driver);
  	        pageFactory.handleMenApparelAction();
  	        
  	        // Assertion
  	        String expectedText = "Men's Jackets";
  	        String actualText = pageFactory.getHeading();
  	        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found: " + expectedText);
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}
 	
  	  
  	// This test case is to check furniture products
  	public void checkFurniture() throws InterruptedException {
  	    test = extent.createTest("checkFurniture", "This test case is to check furniture products");
	    test.log(Status.INFO, "This test case is to check furniture products");
	    logger.info("Checking Furniture products");
  	    try {    
  	        FlipkartFurnitureProducts pageFactory = new FlipkartFurnitureProducts(driver);
  	        pageFactory.checkBlankets();
  	        
  	        // Assertion
  	        String expectedText = "Blankets";
  	        String actualText = pageFactory.getHeading();
  	        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found: " + expectedText);
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}

  	
  	// This test case is to check Offer-Zone Section
  	public void checkOfferZone() throws InterruptedException {
	    test = extent.createTest("checkOfferZone", "This test case is to check Offer-Zone Section");
	    test.log(Status.INFO, "This test case is to check Offer-Zone Section");
	    logger.info("Checking Offer-Zone Products on Flipkart");
  	    try {
  	    	FlipkartOfferZonePage pageFactory = new FlipkartOfferZonePage(driver);
  	        pageFactory.clickOfferZone();
  	        Thread.sleep(2000);
  	        pageFactory.clickSportsWear();
  	        
  	        // Assertion
  	        String expectedText = "Sports Casual Shoes Women's Footwear";
  	        String actualText = pageFactory.getHeading();
  	        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found: " + expectedText);
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}
 	
  	
 // This test case is to check Grocery Store of Flipkart
  	public void checkGrocerySection() throws InterruptedException {
  	    test = extent.createTest("checkGrocerySection", "This test case is to check Grocery Store of Flipkart");
  	    test.log(Status.INFO, "This test case is to check Grocery Store of Flipkart");
  	    logger.info("Checking Grocery Section of Flipkart");
  	    try {
  	        FlipkartGroceryPage pageFactory = new FlipkartGroceryPage(driver);
  	        String groceryLink = ConfigFile.getGroceryLink();
  	        driver.get(groceryLink);
  	        pageFactory.clickGrocery();
  	        
  	        // Assertion
  	        String expectedText = "Vermicelli";
  	        String actualText = pageFactory.getHeading();
  	        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found: " + expectedText);
  	    } catch (Exception e) {
  	    	test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}

  	  
 //  This test case is to check my Cart
  	public void checkMyCart() throws InterruptedException {
	    test = extent.createTest("checkMyCart", "This test case is to check my Cart");
	    test.log(Status.INFO, "This test case is to check my Cart");
	    logger.info("Checking my flipkart Cart");    
  	    try {
  	        FlipkartCheckCart pageFactory = new FlipkartCheckCart(driver);
  	        pageFactory.clickCartButton();
  	        
  	        // Assertion
  	        String expectedText = "New Delhi - 110010";
  	        String actualText = pageFactory.getHeading();
  	        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found: " + expectedText);
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}

  	
 // This test case is to check Flight Booking Section
  	public void checkFlights() throws InterruptedException {
	    test = extent.createTest("checkFlights", "This test case is to check Flight Booking Section");
	    test.log(Status.INFO, "This test case is to check Flight Booking Section");
	    logger.info("Checking Flight section on flipkart Cart");    
  	    try { 
  	        String URL = ConfigFile.getFlightLink();
  	        driver.get(URL);
  	        FlipkartFlightPage pageFactory = new FlipkartFlightPage(driver);
  	        Thread.sleep(1000);
  	        String departureCity = ConfigFile.getDepCity();
  	        String arrivalCity = ConfigFile.getArrCity();
  	        String city = ConfigFile.getCity();
  	        pageFactory.enterDepartureCity(departureCity);
  	        pageFactory.selectCity(city);
  	        pageFactory.enterArrivalCity(arrivalCity);
  	        boolean isClicked = pageFactory.searchFlights();
  	        
  	        // Assertion
   	        Assert.assertTrue(isClicked, "Button was not clicked");
  	    } 
  	    catch (Exception e) {
  	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
  	        throw e;
  	    }
  	}
  	
  	  
//    This test case is for Register functionality
	public void registerUser() throws InterruptedException {
	     test = extent.createTest("registerUser", "This test case is for Register functionality");
         test.log(Status.INFO, "This test case is for Register functionality");
         logger.info("Trying to sign up as a new user");
    	try {
            FlipkartRegister pageFactory = new FlipkartRegister(driver);
            String registerLink = ConfigFile.getRegisterLink();
            driver.get(registerLink);
            pageFactory.handleActionChain();
            pageFactory.clickEmailBox();
            String PhoneNo = ConfigFile.getPhoneNo();
            pageFactory.enterPhoneNumber(PhoneNo);
            pageFactory.clickSubmitButton();
            pageFactory.enterOTP();
            boolean isClicked = pageFactory.clickSignup();
            
            // Assertion
   	        Assert.assertTrue(isClicked, "Button was not clicked");
        } 
    	catch (Exception e) {
            test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
            throw e;
        }
	}  
    
    
//  This test case is for Login Functionality
  public void checkLogin() throws IOException, InterruptedException, MailosaurException {
      test = extent.createTest("checkLogin", "This test case for checking Login functionality");
      test.log(Status.INFO, "Checking Login Functionality on Flipkart Site");
      logger.info("Checking Login Functionality on Flipkart Site");
	  try {
	        String loginURL = ConfigFile.getLoginLink();
	        driver.get(loginURL);
	        FlipkartLoginPage pageFactory = new FlipkartLoginPage(driver);
	        String emailID = ConfigFile.getEmail();
	        pageFactory.clickEmailBox();
	        pageFactory.enterLoginEmail(emailID);
	        pageFactory.clickSubmitBox();
	        String OTP = pageFactory.generateOTP();
	        boolean isClicked = pageFactory.enterOTPBox(OTP);
	        
	        // Assertion
   	        Assert.assertTrue(isClicked, "Button was not clicked");
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	        throw e;
	    }   
  }
  
  
    
//    Method for segregating Tests on Report based on their results
  @AfterMethod
  public void getTestResult(ITestResult result, ITestContext context) throws IOException {
      String testCaseName = (String) context.getAttribute("testCaseName");

      if (result.getStatus() == ITestResult.FAILURE) {
          String methodName = result.getMethod().getMethodName();
          String screenshotPath = Utils.takeScreenShot(driver, testCaseName);
          test.log(Status.FAIL, MarkupHelper.createLabel(testCaseName + " Failed", ExtentColor.RED));
          logger.error(testCaseName + " Failed"); 
          test.addScreenCaptureFromPath(screenshotPath); 
      } 
      else if (result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, MarkupHelper.createLabel(testCaseName + " Passed", ExtentColor.GREEN));
          logger.info(testCaseName + " Passed");
      } 
      else if (result.getStatus() == ITestResult.SKIP) {
          test.log(Status.SKIP, MarkupHelper.createLabel(testCaseName + " Skipped", ExtentColor.YELLOW));
          logger.warn(testCaseName + " Skipped");
      }
  }


//    Method for closing driver
	@AfterTest
	public void tearDownTest() {
		if (driver != null) {
			driver.quit();
		}
		ExtentManager.flushReport();
		System.out.println("Testing done successfully !!!");
	}

	
//	This method provides test data from an Excel file
	@DataProvider(name = "testData")
	public Object[][] provideTestData() throws IOException {
	    return Utils.provideTestData("C:\\Users\\varunbajpai\\eclipse-workspace\\FlipkartTesting\\src\\main\\java\\utils\\testdata\\TestData2.xlsx", "Sheet1");
	}
	
}
