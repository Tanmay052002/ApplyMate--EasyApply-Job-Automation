package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;


public class SkillInputpage extends basetest{

	WebElement job_input;
	
	public SkillInputpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void input(String Skills) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath(loc.getProperty("job_input"))
		)).sendKeys(Skills);

	}
	
}
