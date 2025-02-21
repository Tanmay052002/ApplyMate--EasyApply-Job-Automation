package easyApplypage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basetest.basetest;
import questionspage.QuestionTextPage;

public class FinalTestpage extends basetest {

    QuestionTextPage getquestion;
    Next_btnpage nextOpt;
    review_btnpage reviewOpt;
    SubmitApplicationpage submitOpt;
    Apply_btnpage applyOpt;
    Done_btnpage doneOpt;
    
    WebElement job_card;
    WebElement success_icon;

    public FinalTestpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        nextOpt = new Next_btnpage(driver);
        reviewOpt = new review_btnpage(driver);
        submitOpt = new SubmitApplicationpage(driver);
        applyOpt = new Apply_btnpage(driver);
        doneOpt = new Done_btnpage(driver);
    }

    String Submit_Temp = loc.getProperty("submit_btn");
    String next_Temp = loc.getProperty("Apply_next");
    String review_Temp = loc.getProperty("review_btn");
    String done_btn = loc.getProperty("done_btn");
    String Success_icon = loc.getProperty("success_icon");

    int n = 0;
    public void Solution() throws InterruptedException {
        System.out.println("Entering loop.");

        for (int i = 1;; i++) {
            // Refresh the list of job cards
            List<WebElement> jobCards = driver.findElements(By.xpath(loc.getProperty("job_card")));
            if (i > jobCards.size()) {
                break; // Exit the loop if there are no more job cards
            }
            Thread.sleep(5000);
            WebElement jobCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("job_card")+"[" + i + "]")));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", jobCard);

            jobCard.click();
            
            if (isElementPresent(By.xpath(Success_icon))) {
                System.out.println("Success icon is visible. Moving to the next job card...");
                continue; // Move to the next job card
            } else {
                applyOpt.option(); // Click the easy apply button
            }
            
            while (true) {
                Thread.sleep(5000);
                if (isElementPresent(By.xpath(Submit_Temp))) {
                    System.out.println("Submit button is visible. Clicking it...");
                    submitOpt.option(); // Click submit button
                    System.out.println("Application submitted successfully!");
                    n++;
                } else if (isElementPresent(By.xpath(next_Temp))) {
                    System.out.println("Next button is visible. Clicking it...");
//                    Thread.sleep(5000);
                    nextOpt.option(); // Click next button
                } else if (isElementPresent(By.xpath(review_Temp))) {
                    System.out.println("Review button is visible. Clicking it...");
//                    Thread.sleep(5000);
                    reviewOpt.option(); // Click review button
                } else if (isElementPresent(By.xpath(done_btn))) {
                    System.out.println("Done button is visible. Clicking it...");
                    doneOpt.option(); // Click Done button
                    System.out.println("Done button clicked! Exiting loop.");
                    break;
                } else {
                    System.out.println("Unknown step encountered!");
                    break;
                }
            }
            System.out.println("No. of job Applied : "+n);
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
