package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartCheckProductImages {

    WebElement element = null;
    WebDriver driver = null;

    public FlipkartCheckProductImages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className="ZqtVYK")
    public WebElement imageContainer;

    public boolean iterateOverImages() throws InterruptedException {
    	
        List<WebElement> imageElements = imageContainer.findElements(By.tagName("img"));
        
        // Iterate over each image element
        for (WebElement imageElement : imageElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageElement);
             imageElement.click();
             Thread.sleep(200);
        }
        return true;
    }
}
