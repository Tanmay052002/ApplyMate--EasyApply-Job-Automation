package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class takescreenshot {

    // Method to take screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Cast the WebDriver to TakesScreenshot to access the screenshot functionality
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Get the screenshot as a file
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Format the screenshot name with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destination = "./screenshots/" + screenshotName + "_" + timestamp + ".png";

        // Create a directory if it doesn't exist
        File destinationFile = new File(destination);
        destinationFile.getParentFile().mkdirs();

        // Copy the file to the desired location
        FileHandler.copy(source, destinationFile);

        System.out.println("Screenshot saved to " + destinationFile.getAbsolutePath());
    }

    // Example of how to use the TakeScreenshot class with Facebook login
    public static void main(String[] args) throws IOException {
        // Set up WebDriver (for example, ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open Facebook login page
        driver.get("https://www.facebook.com");

        // Take screenshot of the page
        captureScreenshot(driver, "facebook_login_page");

        // Close the browser
        driver.quit();
    }
}

