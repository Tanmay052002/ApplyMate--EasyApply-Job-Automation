package filterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class JobFunc_itpage extends basetest{

	WebElement jobFunc_it;
	
	public JobFunc_itpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() {

		WebElement jobFunc_it= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("jobFunc_it"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", jobFunc_it);

		jobFunc_it.click();

	}
	
	
}
