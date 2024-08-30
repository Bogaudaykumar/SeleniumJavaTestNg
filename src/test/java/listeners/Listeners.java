package listeners;

import DriverFactory.BaseTest;
import Reports.ExtentReportManager;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.reportConfiguration(context.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        String url = result.getTestContext().getCurrentXmlTest().getParameter("url");
        if (browser != null && url != null) {
            BaseTest.setDriver(browser, url);
            BaseTest.setProperties();
        } else {
            throw new IllegalArgumentException("Browser and URL parameters must be provided in the TestNG XML.");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logPassWithScreenshot( "Test Case Passed: " + result.getMethod().getMethodName());
        BaseTest.driverDropping();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailWithScreenshot("Test Case Failed: " + result.getThrowable());
        BaseTest.driverDropping();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Case Skipped: " + result.getMethod().getMethodName());
        BaseTest.driverDropping();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
       // BaseTest.driverDropping();
    }
}
