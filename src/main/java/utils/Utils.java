package utils;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class Utils {

    public static String handleNewTab(WebDriver driver) {
        String originalTab = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        
        for (String handle : windowHandles) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return originalTab;
    }
}
