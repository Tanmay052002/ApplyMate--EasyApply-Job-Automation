package basetest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader frprop;
    public static FileReader frloc;
    public static SoftAssert softAssert;
    public static WebDriverWait wait;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ExtentSparkReporter sparkReporter;
    public static ThreadLocal<String> assertionMessage;
    WebElement show_btn;

    @BeforeSuite
    public void setupReport() {
        // Initialize ExtentSparkReporter
        sparkReporter = new ExtentSparkReporter("extent-report.html");
        // Initialize ExtentReports
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Additional configurations if needed
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setReportName("Selenium Test Report");
    }

    @BeforeTest
    public void setup() throws IOException {

        if (driver == null) {

            frprop = new FileReader(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
            prop.load(frprop);

            frloc = new FileReader(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties");
            loc.load(frloc);

            // Initialize assertionMessage with a ThreadLocal value
            assertionMessage = new ThreadLocal<>();
        }

        // Select browser based on configuration
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + prop.getProperty("browser"));
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("testURL"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static String getAssertionMessage() {
        return assertionMessage.get();
    }

    public static void scrollPageDown() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    
    public void enter() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
    
    public void show() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("show_btn")))).click();
	}
    

    @AfterTest
    public void tearDown() throws InterruptedException {
        if (driver != null) {
//        	Thread.sleep(10000);
//        	driver.quit(); // Close the browser and end the session
            driver = null; // Clear the reference
        }
    }

    @AfterSuite
    public void tearDownReport() {
        // Flush the report
        extentReports.flush();
    }

    // Method to log any caught exception into Extent Reports
    public static void logExceptionToReport(Exception e) {
        extentTest.log(Status.FAIL, "Exception occurred: " + e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            extentTest.log(Status.FAIL, element.toString());
        }
    }
}
