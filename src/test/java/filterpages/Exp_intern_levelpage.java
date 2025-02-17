package filterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class Exp_intern_levelpage extends basetest{

	WebElement intern_lvl;
	
	public Exp_intern_levelpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() {

		WebElement intern_lvl= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("intern_lvl"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", intern_lvl);

		intern_lvl.click();

	}
	
	
}
