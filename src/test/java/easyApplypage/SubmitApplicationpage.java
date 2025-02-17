package easyApplypage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;

public class SubmitApplicationpage extends basetest{
	public static WebElement submit_btn;
	public SubmitApplicationpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	public void option() {
		submit_btn= wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath(loc.getProperty("submit_btn"))));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", submit_btn);

			submit_btn.click();

	}
	
}
