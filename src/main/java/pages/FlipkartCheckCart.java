package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartCheckCart {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartCheckCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[text()=\"New Delhi - 110010\"])")
	private WebElement heading;
	
	@FindBy(xpath = "//a[@href=\"/viewcart?exploreMode=true&preference=GROCERY\"][1]")
    private WebElement cartButton;
	
	public void clickCartButton() {
		cartButton.click();
	}
	
	public String getHeading() {
		return heading.getText();
	}
	
}
