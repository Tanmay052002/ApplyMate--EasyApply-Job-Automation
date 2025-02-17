package questionspage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basetest.basetest;


public class QuestionTextPage extends basetest{

	public static WebElement questions;

	
	public QuestionTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void ques() throws InterruptedException {
		Thread.sleep(2000);
//		WebElement easyApply = wait.until(ExpectedConditions.visibilityOfElementLocated(
//		    By.xpath(loc.getProperty("easyApply"))));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", easyApply);
//
//		easyApply.click();
		List<WebElement> questionElements = driver.findElements(By.xpath(loc.getProperty("questions")));
	    System.out.println(questionElements.size());

		for (WebElement questionElement : questionElements) {
		    String questionText = questionElement.getText();
		    System.out.println("Question: " + questionText);
		}

	}
	
}
