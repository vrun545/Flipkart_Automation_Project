package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartAddToCart {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartAddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()=\"Add to cart\"]")
	public WebElement addToCartButton;
	
	@FindBy(xpath="//button[@class=\"QqFHMw vslbG+ In9uk2\"]")
	public WebElement goToCartButton;

	
	public boolean clickAddToCartButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickableAddToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickableAddToCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableAddToCartButton);
        System.out.println("Add to cart button clicked");
        goToCartButton.click();
        return true;
	}
	
}
