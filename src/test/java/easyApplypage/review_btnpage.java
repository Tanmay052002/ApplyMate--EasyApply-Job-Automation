package easyApplypage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;

public class review_btnpage extends basetest{
	public static WebElement review_btn;
	public review_btnpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	public void option() {
	
			review_btn= wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath(loc.getProperty("review_btn"))));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", review_btn);
	
				review_btn.click();
	
//				try {
//		} catch (Exception e) {
//			// Code to handle the exception
//			System.out.println("Review Button not Appeared");
//		}
	}
	
}
