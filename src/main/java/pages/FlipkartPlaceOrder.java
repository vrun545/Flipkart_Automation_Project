package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPlaceOrder {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartPlaceOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Place Order\"]")
	public WebElement orderButton;
	
	@FindBy(xpath="//input[@type=\"text\"]")
	public WebElement emailBox;
	
	public void clickOrderButton() {
		orderButton.click();
	}
	
	public boolean enterEmail() {
		emailBox.sendKeys("anything@mtnnrid4.mailosaur.net");
		return true;
	}
}
