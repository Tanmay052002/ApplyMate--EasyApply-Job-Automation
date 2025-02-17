package easyApplypage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class Apply_btnpage extends basetest{

	WebElement easyApply;
	
	public Apply_btnpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() throws InterruptedException {
		Thread.sleep(2000);
		WebElement easyApply = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("easyApply"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", easyApply);

		easyApply.click();

	}
	
}
