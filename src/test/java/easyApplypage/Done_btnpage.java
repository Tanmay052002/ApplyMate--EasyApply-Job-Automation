package easyApplypage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class Done_btnpage extends basetest{

	public static WebElement done_btn;
	
	public Done_btnpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option()  {
				
		done_btn= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("done_btn"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", done_btn);

		done_btn.click();

		

	}
}
	
