package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartSearchBox {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartSearchBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name=\"q\"]")
	public WebElement searchBox;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[text()=\"Apple iPhone 15 Pro Max (Natural Titanium, 256 GB)\"]")
	public WebElement productLink;
	
	
	public void clickSearchBox() {
		searchBox.click();
	}
	
	public void enterProductName(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public boolean clickProduct() {
		productLink.click();
		return true;
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}

}
