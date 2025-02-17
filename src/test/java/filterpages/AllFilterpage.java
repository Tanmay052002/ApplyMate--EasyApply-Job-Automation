package filterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class AllFilterpage extends basetest{

	WebElement filter_btn;
	
	public AllFilterpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() {

		WebElement filter_btn= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("filter_btn"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", filter_btn);

		filter_btn.click();

	}
}
