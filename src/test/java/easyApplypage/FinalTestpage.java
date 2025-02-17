package easyApplypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basetest.basetest;
import questionspage.QuestionTextPage;

public class FinalTestpage extends basetest {

    QuestionTextPage getquestion;
    Next_btnpage nextOpt;
    review_btnpage reviewOpt;
    SubmitApplicationpage submitOpt;

    public FinalTestpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        nextOpt = new Next_btnpage(driver);
        reviewOpt = new review_btnpage(driver);
        submitOpt = new SubmitApplicationpage(driver);
    }

    String Submit_Temp = loc.getProperty("submit_btn");
    String next_Temp = loc.getProperty("Apply_next");
    String review_Temp = loc.getProperty("review_btn");

    public void Solution() {
        System.out.println("Entering loop.");
        while (true) {
            if (isElementPresent(By.xpath(Submit_Temp))) {
                System.out.println("Submit button is visible. Clicking it...");
                submitOpt.option(); // Click submit button
                System.out.println("Application submitted successfully! Exiting loop.");
                break;
            } else if (isElementPresent(By.xpath(next_Temp))) {
                System.out.println("Next button is visible. Clicking it...");
                nextOpt.option(); // Click next button
            } else if (isElementPresent(By.xpath(review_Temp))) {
                System.out.println("Review button is visible. Clicking it...");
                reviewOpt.option(); // Click review button
            } else {
                System.out.println("Unknown step encountered!");
                break;
            }
        }
    }

    private boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
