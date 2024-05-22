package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartClickProductHome {
	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartClickProductHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class=\"zlQd20 _1eDlvI\"])[3]")
	public WebElement productImg;
	
	@FindBy(xpath="(//img[@title=\"Flipkart\"])")
	public WebElement HomeButton;
	
	public void clickOnHomeBtn() {
		HomeButton.click();
	}
	
	public boolean clickOnProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visibleProductImage = wait.until(ExpectedConditions.visibilityOf(productImg));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", visibleProductImage);
        wait.until(ExpectedConditions.elementToBeClickable(visibleProductImage)).click();
        return true;
	}
	
}
