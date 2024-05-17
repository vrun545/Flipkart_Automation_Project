package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


public class FlipkartChangePincode {
	
	WebElement element = null;
	WebDriver driver = null;
	private Wait<WebDriver> wait;
	
	public FlipkartChangePincode(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='hVvnXm']")
	public WebElement expectedText;
	
	
	@FindBy(xpath="//input[@id=\"pincodeInputId\"]")
	public WebElement pincodeBox;
	
	
	public void enterPincode(String pincode) throws InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(pincodeBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pincodeBox);
		pincodeBox.sendKeys(pincode);
		pincodeBox.sendKeys(Keys.RETURN);
	}
	
	public String getExpectedText() {
		return expectedText.getText();
	}

}
