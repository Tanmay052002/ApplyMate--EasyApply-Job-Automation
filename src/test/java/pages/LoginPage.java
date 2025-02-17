package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;

public class LoginPage extends basetest {
		
	WebElement sign_in_btn;
	WebElement username;
	WebElement password;
	WebElement remember_btn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sign_in() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("sign_in_btn"))))
				.click();
	}
	public void ent_username(String Username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("username"))))
		.sendKeys(Username);
	}
	public void ent_Password(String Password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("password"))))
		.sendKeys(Password);
	}
	public void remember_me_btn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("remember_btn")))).click();
	}
	
	
}
