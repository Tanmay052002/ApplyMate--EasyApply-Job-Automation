package filterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class Exp_ent_levelpage extends basetest{

	WebElement entry_lvl;
	
	public Exp_ent_levelpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void option() {

		WebElement entry_lvl= wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("entry_lvl"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", entry_lvl);

		entry_lvl.click();

	}
	
	
}
