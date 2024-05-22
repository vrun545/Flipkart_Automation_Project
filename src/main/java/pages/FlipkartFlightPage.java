package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartFlightPage {

	WebElement element = null;
	WebDriver driver = null;
	
	public FlipkartFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='0-departcity']")
    private WebElement inputDepartCity;
	
	@FindBy(css = "input[name='0-arrivalcity']")
    private WebElement inputArrivalCity;

    @FindBy(css = "div._98hP1j span")
    private List<WebElement> cityOptions;
    
    @FindBy(xpath="//button[@type=\"button\"]")
    private WebElement searchButton;
    
    public void enterDepartureCity(String city) {
        inputDepartCity.sendKeys(city);
    }
    
    public void enterArrivalCity(String city) {
        inputArrivalCity.sendKeys(city);
    }

    public void selectCity(String cityName) {
        for (WebElement cityOption : cityOptions) {
            if (cityOption.getText().contains(cityName)) {
                cityOption.click();
                break;
            }
        }
    }
    
    public boolean searchFlights() {
    	searchButton.click();
    	return true;
    }
}
    
