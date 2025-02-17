package basetest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.takescreenshot;

public class Listeners extends takescreenshot implements ITestListener {

    // Initialize ExtentReports object (can be static if shared across all listeners)
    private static ExtentReports extentReports = new ExtentReports(); // Initialize the ExtentReports object
    private static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the extent report
        extentTest = extentReports.createTest(result.getMethod().getMethodName());

        // Add a description to the test if provided
        String description = result.getMethod().getDescription();
        if (description != null && !description.isEmpty()) {
            extentTest.log(Status.INFO, "Test Description: " + description);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success
        extentTest.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure
        extentTest.log(Status.FAIL, "Test failed");

        // Capture exception details
        Throwable throwable = result.getThrowable();
        if (throwable instanceof AssertionError) {
            // Log assertion failure details
            String assertionMsg = basetest.getAssertionMessage();
            extentTest.log(Status.FAIL, "Assertion Failed: " + assertionMsg);
        } else {
            // Log other exceptions (like Selenium exceptions)
            extentTest.log(Status.FAIL, "Test failed with exception: " + throwable.getMessage());
            basetest.logExceptionToReport(new Exception(throwable));
        }

        // Capture screenshot on failure
        String testCaseName = result.getMethod().getMethodName();
        takescreenshot(testCaseName); // Assuming takeScreenshot method is in takescreenshot class
    }

    private void takescreenshot(String testCaseName) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped tests
        extentTest.log(Status.SKIP, "Test skipped");
    }

    // To initialize and close the ExtentReports instance (could be handled in BaseTest or Listeners)
    public static void startReporting() {
        // Initialize the ExtentReports object and set configuration if needed
        extentReports = new ExtentReports();
        // Add additional configurations to extentReports if needed (e.g., set paths, etc.)
    }

    public static void endReporting() {
        // Flush the reports to file
        extentReports.flush();
    }
}
