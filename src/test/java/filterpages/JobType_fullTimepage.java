package filterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class JobType_fullTimepage extends basetest{

	WebElement f_time;
	
	public JobType_fullTimepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() {

		WebElement f_time= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("f_time"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", f_time);

		f_time.click();

	}
	
	
}
