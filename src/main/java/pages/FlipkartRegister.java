package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartRegister {
	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartRegister(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=\"Login\"]")
	public WebElement loginLink;

	@FindBy(xpath="//input[@class=\"r4vIwl BV+Dqf\"]")
	public WebElement phoneNo_Box;
	
	@FindBy(xpath="//div[text()=\"Sign Up\"]")
	public WebElement signUpLink;
	
	@FindBy(xpath="(//span[text()=\"CONTINUE\"])")
	public WebElement submitButton;
	
	@FindBy(xpath="//span[text()=\"Enter OTP\"]")
	public WebElement OTP;
	
	@FindBy(xpath="//span[text()=\"Signup\"]")
	public WebElement signupButton;
	
	public void handleActionChain() throws InterruptedException {
	    Actions actions = new Actions(driver);
	    actions.moveToElement(loginLink).perform();
	    signUpLink.click();
	}
	
	public void clickEmailBox() {
		phoneNo_Box.click();
	}
	
	public void enterPhoneNumber(String PhoneNo) {
		phoneNo_Box.sendKeys(PhoneNo);
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void enterOTP() {
		OTP.sendKeys("216545");
	}
	
	public boolean clickSignup() {
		signupButton.click();
		return true;
	}

}
