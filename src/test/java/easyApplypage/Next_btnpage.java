package easyApplypage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class Next_btnpage extends basetest{

	public static WebElement Apply_next;
	
	public Next_btnpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option()  {
				
		Apply_next= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("Apply_next"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Apply_next);

		Apply_next.click();

		

	}
	
}
