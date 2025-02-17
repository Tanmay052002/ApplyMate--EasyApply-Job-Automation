package filterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class Easyapplypage extends basetest{

	WebElement easy_apply_btn;
	
	public Easyapplypage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() throws InterruptedException {
		Thread.sleep(2000);
		WebElement easy_apply_btn= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("easy_apply_btn"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", easy_apply_btn);

		easy_apply_btn.click();

	}
	
	
}
