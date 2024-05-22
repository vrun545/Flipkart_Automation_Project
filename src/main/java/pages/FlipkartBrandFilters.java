package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlipkartBrandFilters {
	
	WebElement element = null;
	WebDriver driver = null;
	private Wait<WebDriver> wait;
	
	public FlipkartBrandFilters(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='SAMSUNG']/preceding-sibling::div")
    private WebElement samsungCheckbox;

   
    public boolean brandFilter() {
    	wait.until(ExpectedConditions.elementToBeClickable(samsungCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", samsungCheckbox);
        samsungCheckbox.click();
        return true;
     }

}
