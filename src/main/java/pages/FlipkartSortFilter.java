package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlipkartSortFilter {
	
	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartSortFilter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Price -- Low to High']")
    private WebElement lowToHigh;
	
	public boolean applySortLowToHigh() throws InterruptedException {
		Thread.sleep(1000);
		lowToHigh.click();
		return true;
	}

}
