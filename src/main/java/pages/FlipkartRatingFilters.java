package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartRatingFilters {
	

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartRatingFilters(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='tKgS7w']//select[@class='Gn+jFg']")
    private WebElement dropdown;
	
	public boolean ratingFilter() {
		return true;
	}

}
