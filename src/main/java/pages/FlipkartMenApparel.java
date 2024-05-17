package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartMenApparel {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartMenApparel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Men\"]")
	private WebElement men;
	
	@FindBy(xpath = "//a[@title=\"Jackets\"]")
    private WebElement jackets;
	
	@FindBy(xpath="(//h1[text()=\"Men's Jackets\"])")
	private WebElement heading;
	
	public void handleMenApparelAction() throws InterruptedException {
		Actions actions = new Actions(driver);
        actions.moveToElement(men).perform();
        jackets.click();
		Thread.sleep(2000);
	}
	
	public String getHeading() {
		return heading.getText();
	}
   
}
