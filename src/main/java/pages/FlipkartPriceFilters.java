package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlipkartPriceFilters {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartPriceFilters(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='tKgS7w']//select[@class='Gn+jFg']")
    private WebElement dropdown;
   
	
	public boolean priceTag() {
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByValue("10000");
		dropdownSelect.selectByValue("20000");
		return true;
	}
}
