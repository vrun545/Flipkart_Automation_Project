package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartOfferZonePage {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartOfferZonePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=\"Offer Zone\"]")
	private WebElement offerZone;
	
	@FindBy(xpath = "(//img[@alt=\"ADIDAS SUPERNOVA 2 W Running Shoes For Women\"])")
    private WebElement sportsWear;
	
	@FindBy(xpath="(//h1[text()=\"Sports Casual Shoes Women's Footwear\"])")
	private WebElement heading;
	
	public void clickOfferZone() throws InterruptedException {
		offerZone.click();
	}
	
	public void clickSportsWear() {
		sportsWear.click();
	}
	
	public String getHeading() {
		return heading.getText();
	}
	
}
