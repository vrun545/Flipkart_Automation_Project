package pages;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import reports.ReadConfigFile;

public class FlipkartLoginPage {

	WebElement element = null;
	WebDriver driver = null;
	ReadConfigFile ConfigFile = new ReadConfigFile();
	String API_KEY = ConfigFile.getAPI_KEY();
    String serverID = ConfigFile.getServerID();
    String from = "noreply@ncb.flipkart.com";
	
	public FlipkartLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@title=\"Login\"])[1]")
	public WebElement loginBtn;
	
	@FindBy(xpath="//input[@class=\"r4vIwl BV+Dqf\"]")
	public WebElement email_TextBox;
	
	@FindBy(xpath="//button[@class=\"QqFHMw twnTnD _7Pd1Fp\"]")
	public WebElement requestOTP_Btn;

	@FindBy(xpath="//div[@class=\"XDRRi5\"]")
	public WebElement OTP_Box;
	
	public String getRandomEmail() {
		return "user" + System.currentTimeMillis() + "@";
	}
	
	public void clickEmailBox() {
		email_TextBox.click();
	}
	
	public void enterLoginEmail(String emailId) {
		email_TextBox.sendKeys(emailId);
	}
	
	public void clickSubmitBox() {
		requestOTP_Btn.click();
	}
	
	public boolean enterOTPBox(String OTP) {
		OTP_Box.sendKeys(OTP);
		return true;
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
//	Method to read OTP from Email Inbox
	public String generateOTP() throws IOException, MailosaurException {
        String serverDomain = ConfigFile.getServerDomain();
        System.out.println(serverDomain);
		MailosaurClient mailosaur = new MailosaurClient(API_KEY);
        
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverID);
        
        SearchCriteria criteria = new SearchCriteria();
        String emailID = ConfigFile.getEmail();
        criteria.withSentTo(emailID);
        criteria.withSentFrom(from);
        
        Message message = mailosaur.messages().get(params, criteria);
        String subject = message.subject();
        System.out.println(subject);
        
//        Get OTP
        Pattern pattern = Pattern.compile("Flipkart Account - .*([0-9]{6}.*)");
        Matcher matcher = pattern.matcher(subject);
        matcher.find();
        
        String OTP = matcher.group(1);
        return OTP;
	}
}
