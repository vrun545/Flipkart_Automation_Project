package utils;

import org.openqa.selenium.WebDriver;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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
    
    
    
    public static String takeScreenShot(WebDriver driver, String methodName) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        // Capture the screenshot as File
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            // Define the directory path for the screenshots
            String directory = "src/main/java/reports/extentreports/screenshots/";
            // Create the directory if it does not exist
            new File(directory).mkdirs();
            // Define the destination path for the screenshot
            Path destinationPath = Paths.get(directory + methodName + "_" + getCurrentTimeStamp() + ".png");
            // Copy the screenshot to the destination path
            Files.copy(source.toPath(), destinationPath);
            System.out.println("Screenshot taken: " + destinationPath);
            // Return the path of the saved screenshot
            return destinationPath.toAbsolutePath().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "No File";
        }
    }

    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
}
