package listeners;
import DriverFactory.BaseTest;
import Reports.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.RecordUtil;
import mail.gmail;
import java.util.*;
import javax.mail.MessagingException;

import static DriverFactory.BaseTest.configReader;
import static Reports.ExtentReportManager.startTest;

public class Listeners implements ITestListener
{
    private List<String[]> testCaseDetails = new ArrayList<>();
    @Override
    public void onStart(ITestContext context)
    {
        try {
            configReader();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        try {
            RecordUtil.startRecord(context.getName().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExtentReportManager.reportConfiguration();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        String url = result.getTestContext().getCurrentXmlTest().getParameter("url");
        startTest(result.getMethod().getMethodName());
        //String browser = System.getProperty("browser");
        //String url = System.getProperty("url");
        if (browser != null && url != null) {
            try {
                BaseTest.browserSelection(browser, url);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            throw new IllegalArgumentException("Browser and URL parameters must be provided in the TestNG XML.");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        if(groups!=null)
        {
            ExtentReportManager.logPassWithScreenshot( "Test Case Passed: " + result.getMethod().getMethodName(), groups);
        }
        else{
            ExtentReportManager.logPassWithScreenshot( "Test Case Passed: " + result.getMethod().getMethodName());
        }
        ExtentReportManager.addTestSummaryTable();
        testCaseDetails.add(new String[]{result.getMethod().getMethodName(), "PASSED", String.valueOf(result.getEndMillis() - result.getStartMillis()) + " ms"});


        BaseTest.driverDropping();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String[] groups = result.getMethod().getGroups();
        if(groups!=null)
        {
            ExtentReportManager.logFailWithScreenshot( "Test Case Failed: " + result.getMethod().getMethodName(), groups);
        }
        else{
            ExtentReportManager.logFailWithScreenshot("Test Case Failed: " + result.getThrowable());
        }
        ExtentReportManager.addTestSummaryTable();
        testCaseDetails.add(new String[]{result.getMethod().getMethodName(), "FAILED", String.valueOf(result.getEndMillis() - result.getStartMillis()) + " ms"});



        BaseTest.driverDropping();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Case Skipped: " + result.getMethod().getMethodName());
        ExtentReportManager.addTestSummaryTable();
        testCaseDetails.add(new String[]{result.getMethod().getMethodName(), "SKIPPED", ""});


        BaseTest.driverDropping();
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            RecordUtil.stopRecord();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        StringBuilder htmlContent = new StringBuilder("<html><body>");
        htmlContent.append("<h2>Test Report</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='background-color: #d4f0d0;'>");
        htmlContent.append("<tr>")
                .append("<th>S.No</th>")
                .append("<th>Test Case</th>")
                .append("<th>Status</th>")
                .append("<th>Execution Time</th>")
                .append("</tr>");
        int sno = 1;
        for (String[] details : testCaseDetails) {
            String statusColor;
            switch (details[1]) {
                case "PASSED":
                    statusColor = "#d4edda";
                    break;
                case "FAILED":
                    statusColor = "#f8d7da";
                    break;
                case "SKIPPED":
                    statusColor = "#fff3cd";
                    break;
                default:
                    statusColor = "#ffffff";
            }
            htmlContent.append("<tr>")
                    .append("<td>").append(sno++).append("</td>")
                    .append("<td>").append(details[0]).append("</td>")
                    .append("<td style='background-color: ").append(statusColor).append(";'>").append(details[1]).append("</td>")
                    .append("<td>").append(details[2]).append("</td>")
                    .append("</tr>");
        }
        htmlContent.append("</table>");
        htmlContent.append("</body></html>");
        ExtentReportManager.flushReport();
        gmail.sendEmail("bogaudaykumar75@gmail.com", "axea ydku uxxt euou\n", "bogaudaykumar75@gmail.com", "Testing", htmlContent.toString());
        // BaseTest.driverDropping();
    }
}
/*
import DriverFactory.BaseTest;
import Reports.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.RecordUtil;
import java.util.ArrayList;
import java.util.List;
import static DriverFactory.BaseTest.configReader;
import static Gmail.gmail.sendEmail;
import static Reports.ExtentReportManager.startTest;

public class Listeners implements ITestListener {
    private List<String[]> testCaseDetails = new ArrayList<>();
    @Test(priority = 0)
    public void openBrowser() throws Exception {
        parentTest = extent.createTest("TC_1_open browser");
        parentTest.assignCategory("Sanity Testing");
        parentTest.log(Status.INFO, "Opening browser");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        parentTest.log(Status.PASS, MarkupHelper.createLabel("Application is open", ExtentColor.BLUE));
    }
    @Override
    public void onStart(ITestContext context) {
        try {
            configReader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ExtentReportManager.reportConfiguration();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        String url = result.getTestContext().getCurrentXmlTest().getParameter("url");
        startTest(result.getMethod().getMethodName());
        try {
            RecordUtil.startRecord(result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (browser != null && url != null) {
            try {
                BaseTest.browserSelection(browser, url);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Browser and URL parameters must be provided in the TestNG XML.");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.logPassWithScreenshot("Test Case Passed: " + result.getMethod().getMethodName());
        ExtentReportManager.addTestSummaryTable();
        testCaseDetails.add(new String[]{result.getMethod().getMethodName(), "PASSED", String.valueOf(result.getEndMillis() - result.getStartMillis()) + " ms"});
        BaseTest.driverDropping();
        try {
            RecordUtil.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailWithScreenshot("Test Case Failed: " + result.getThrowable());
        ExtentReportManager.addTestSummaryTable();
        testCaseDetails.add(new String[]{result.getMethod().getMethodName(), "FAILED", String.valueOf(result.getEndMillis() - result.getStartMillis()) + " ms"});
        BaseTest.driverDropping();
        try {
            RecordUtil.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Case Skipped: " + result.getMethod().getMethodName());
        ExtentReportManager.addTestSummaryTable();
        testCaseDetails.add(new String[]{result.getMethod().getMethodName(), "SKIPPED", ""});
        BaseTest.driverDropping();
        try {
            RecordUtil.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        StringBuilder htmlContent = new StringBuilder("<html><body>");
        htmlContent.append("<h2>Test Report</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='background-color: #d4f0d0;'>");
        htmlContent.append("<tr>")
                .append("<th>S.No</th>")
                .append("<th>Test Case</th>")
                .append("<th>Status</th>")
                .append("<th>Execution Time</th>")
                .append("</tr>");
        int sno = 1;
        for (String[] details : testCaseDetails) {
            String statusColor;
            switch (details[1]) {
                case "PASSED":
                    statusColor = "#d4edda";
                    break;
                case "FAILED":
                    statusColor = "#f8d7da";
                    break;
                case "SKIPPED":
                    statusColor = "#fff3cd";
                    break;
                default:
                    statusColor = "#ffffff";
            }
            htmlContent.append("<tr>")
                    .append("<td>").append(sno++).append("</td>")
                    .append("<td>").append(details[0]).append("</td>")
                    .append("<td style='background-color: ").append(statusColor).append(";'>").append(details[1]).append("</td>")
                    .append("<td>").append(details[2]).append("</td>")
                    .append("</tr>");
        }
        htmlContent.append("</table>");
        htmlContent.append("</body></html>");

        // sendEmail("bogaudaykumar75@gmail.com", "axea ydku uxxt euou", "bogaudaykumar75@gmail.com", "Testing", htmlContent.toString());
        ExtentReportManager.flushReport();
    }
}
*/
/*
// Your test steps here
    ExtentReportManager.logInfoWithScreenshot("Step 1: Navigated to homepage");
    ExtentReportManager.logPassWithScreenshot("Step 2: Login successful");

// More test steps...

    ExtentReportManager.addTestSummaryTable();
}

@AfterSuite
public void tearDown() {
    ExtentReportManager.flushReport();*/