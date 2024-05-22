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

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Utils {
	
//	This Method Provides test data from an Excel file.
	public static Object[][] provideTestData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Object[][] testData = new Object[rowCount][2];
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            String testCaseName = row.getCell(0).getStringCellValue();
            String executionRequired = row.getCell(1).getStringCellValue();
            testData[i - 1][0] = testCaseName;
            testData[i - 1][1] = executionRequired;
        }
        return testData;
    }
	

//	This method is for handling New Tab
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
    
    
//    This method is for taking screenshot of Failed Test Cases
    public static String takeScreenShot(WebDriver driver, String methodName) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            String directory = "src/main/java/reports/extentreports/screenshots/";
            new File(directory).mkdirs();
            Path destinationPath = Paths.get(directory + methodName + "_" + getCurrentTimeStamp() + ".png");
            Files.copy(source.toPath(), destinationPath);
            System.out.println("Screenshot taken: " + destinationPath);
            return destinationPath.toAbsolutePath().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "No File";
        }
    }

    
//    This method is for capturing screenshot in real time
    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
}
