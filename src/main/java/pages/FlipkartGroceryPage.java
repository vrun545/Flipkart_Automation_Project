package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartGroceryPage {
	
	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartGroceryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=\"Grocery\"]")
	private WebElement Grocery;
	
	@FindBy(xpath = "//div[text()=\"Packaged Food\"]")
    private WebElement packagedFood;
	
	@FindBy(xpath="//a[text()=\"Noodles & Pasta\"]")
	private WebElement noodles_pasta;
	
	@FindBy(xpath="//a[text()=\"Vermicelli\"]")
	private WebElement vermicelli;
	
	@FindBy(xpath="//h1[text()=\"Vermicelli\"]")
	private WebElement heading;
	
	public void clickGrocery() throws InterruptedException {
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
        actions.moveToElement(packagedFood).perform();
        actions.moveToElement(noodles_pasta).perform();
        vermicelli.click();
		Thread.sleep(2000);
	}
	
	public String getHeading() {
		return heading.getText();
	}
}
