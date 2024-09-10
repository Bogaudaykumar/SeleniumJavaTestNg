package Reports;
import DriverFactory.BaseTest;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static DriverFactory.BaseTest.threadDriver;
/*
public class ExtentReportManager {
    private static ExtentReports extent;
    static ExtentSparkReporter sparkReporter;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static void reportConfiguration(String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path=System.getProperty("user.dir")+"\\reports\\"+"new_report_.html";
        if (extent == null) {
            sparkReporter = new ExtentSparkReporter(path);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation");
            sparkReporter.config().setReportName("functional testing");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("environment", "QA");
            extent.setSystemInfo("browser name", "chrome");
            extent.setSystemInfo("Tester", "uday");
            if (extent != null) {
                test.set(extent.createTest(testName));
            } else {
                throw new IllegalStateException("ExtentReports is not initialized. Call setup() first.");
            }
        }
    }


    public static ExtentTest getTest() {
        return test.get();
    }

    public static String captureScreenshotAsBase64() {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver1.get();
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void logPassWithScreenshot( String message) {
        String base64Screenshot = captureScreenshotAsBase64();
        getTest().pass(message, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void logFailWithScreenshot( String message) {
        String base64Screenshot = captureScreenshotAsBase64();
        getTest().fail(message, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }
    public static void logInfoWithScreenshot(String message) {
        String base64Screenshot = captureScreenshotAsBase64();
        //getTest().info(message, com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        getTest().info(message,com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    public static void attachScreenshot(String base64Screenshot) {
        getTest().addScreenCaptureFromBase64String(base64Screenshot);
    }

    public static void flushReport() {
            extent.flush();
    }
}

*/

import DriverFactory.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static DriverFactory.BaseTest.threadDriver;
/*
public class ExtentReportManager extends BaseTest {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest extentTest;

    public static void reportConfiguration() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "\\reports\\" + "new_report_.html";
            sparkReporter = new ExtentSparkReporter(path);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation");
            sparkReporter.config().setReportName("Functional Testing");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser Name", "Chrome");
            extent.setSystemInfo("Tester", "Uday");
        }
    }

    public static ExtentTest getTest() {
        return extentTest;
    }

    public static void startTest(String testName){
        extentTest = extent.createTest(testName);
    }

    public static void logPassWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }

    public static String captureScreenshotAsBase64() {
        WebDriver driver = threadDriver.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Cannot capture screenshot.");
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void logInfoWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }

    public static void logFailWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }

    public static void attachScreenshot(String base64Screenshot) {
        if (extentTest != null) {
            extentTest.addScreenCaptureFromBase64String(base64Screenshot);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
*/
/*
import DriverFactory.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static DriverFactory.BaseTest.threadDriver;

public class ExtentReportManager extends BaseTest {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest extentTest;
    private static Map<String, String> testSummary = new HashMap<>();

    public static void reportConfiguration() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "\\reports\\" + "new_report_.html";
            sparkReporter = new ExtentSparkReporter(path);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation");
            sparkReporter.config().setReportName("Functional Testing");
            sparkReporter.viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.CATEGORY,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    })
                    .apply();

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser Name", "Chrome");
            extent.setSystemInfo("Tester", "Uday");
            System.out.println("dfgt");
        }
    }

    public static ExtentTest getTest() {
        return extentTest;
    }

    public static void startTest(String testName) {
        extentTest = extent.createTest(testName);
        testSummary.put(testName, "");
    }

    public static void logPassWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Pass", message);
        }
    }

    public static String captureScreenshotAsBase64() {
        WebDriver driver = threadDriver.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Cannot capture screenshot.");
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void logInfoWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Info", message);
        }
    }

    public static void logFailWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Fail", message);
        }
    }

    public static void attachScreenshot(String base64Screenshot) {
        if (extentTest != null) {
            extentTest.addScreenCaptureFromBase64String(base64Screenshot);
        }
    }

    private static void updateTestSummary(String status, String message) {
        String testName = extentTest.getModel().getName();
        String currentSummary = testSummary.get(testName);
        testSummary.put(testName, currentSummary + String.format("%s: %s\n", status, message));
    }

    public static void addTestSummaryTable() {
        if (extentTest != null) {
            String testName = extentTest.getModel().getName();
            String summary = testSummary.get(testName);

            String tableHtml = "<table style='width:100%; border-collapse: collapse;'>" +
                    "<tr style='background-color: #f2f2f2;'><th style='border: 1px solid #ddd; padding: 8px;'>Step</th><th style='border: 1px solid #ddd; padding: 8px;'>Details</th></tr>";

            for (String line : summary.split("\n")) {
                String[] parts = line.split(": ", 2);
                if (parts.length == 2) {
                    tableHtml += String.format("<tr><td style='border: 1px solid #ddd; padding: 8px;'>%s</td><td style='border: 1px solid #ddd; padding: 8px;'>%s</td></tr>", parts[0], parts[1]);
                }
            }
            tableHtml += "</table>";

            extentTest.info("Test Summary");
            extentTest.info(tableHtml);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}*/
//////////////////////////////////////
/*
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportManager extends BaseTest {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest extentTest;
    private static Map<String, List<Map<String, String>>> testSummary = new HashMap<>();

    public static void reportConfiguration() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "\\reports\\" + "new_report_.html";
            sparkReporter = new ExtentSparkReporter(path);
            sparkReporter.config().setTheme(Theme.STANDARD); // Set to STANDARD for a lighter theme
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("Functional Testing");
            sparkReporter.viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.CATEGORY,
                            ViewName.AUTHOR,
                            ViewName.DEVICE,
                            ViewName.EXCEPTION,
                            ViewName.LOG
                    })
                    .apply();

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser Name", "Chrome");
            extent.setSystemInfo("Tester", "Uday");
        }
    }

    public static ExtentTest getTest() {
        return extentTest;
    }

    public static void startTest(String testName) {
        extentTest = extent.createTest(testName);
        testSummary.put(testName, new ArrayList<>());
    }

    public static void logPassWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Pass", message);
        }
    }

    public static String captureScreenshotAsBase64() {
        WebDriver driver = threadDriver.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Cannot capture screenshot.");
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void logInfoWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Info", message);
        }
    }

    public static void logFailWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Fail", message);
        }
    }

    public static void attachScreenshot(String base64Screenshot) {
        if (extentTest != null) {
            extentTest.addScreenCaptureFromBase64String(base64Screenshot);
        }
    }

    private static void updateTestSummary(String status, String message) {
        String testName = extentTest.getModel().getName();
        List<Map<String, String>> summaries = testSummary.getOrDefault(testName, new ArrayList<>());

        Map<String, String> stepDetails = new HashMap<>();
        stepDetails.put("ID", String.valueOf(summaries.size() + 1)); // ID is the step number
        stepDetails.put("TestStep", message);
        stepDetails.put("Status", status);
        stepDetails.put("Timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        summaries.add(stepDetails);
        testSummary.put(testName, summaries);
    }


    public static void addTestSummaryTable() {
        if (extentTest != null) {
            String testName = extentTest.getModel().getName();
            List<Map<String, String>> summaries = testSummary.get(testName);

            String tableHtml = "<table style='width:100%; border-collapse: collapse;'>" +
                    "<tr style='background-color: #f2f2f2;'>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>ID</th>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>Test Step</th>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>Status</th>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>Timestamp</th>" +
                    "</tr>";

            for (Map<String, String> details : summaries) {
                tableHtml += String.format(
                        "<tr>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "</tr>",
                        details.get("ID"), details.get("TestStep"), details.get("Status"), details.get("Timestamp")
                );
            }
            tableHtml += "</table>";

            extentTest.info("Test Summary").info(tableHtml);
        }
    }



    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
*/
//////////////////

import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportManager extends BaseTest {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReports;
    private static ExtentTest parentTest;
    private static Map<String, List<Map<String, String>>> testSummary = new HashMap<>();
    public static void reportConfiguration() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String path = System.getProperty("user.dir") + "\\reports\\" + "new_report_.html";
            htmlReports=new ExtentHtmlReporter(path);
            extent = new ExtentReports();
            extent.attachReporter(htmlReports);
            htmlReports.config().setReportName("testing");
            htmlReports.config().setTheme(Theme.STANDARD);
            htmlReports.config().setDocumentTitle("HTMLReportsTestResults");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser Name", "Chrome");
            extent.setSystemInfo("Tester", "Uday");
        }
    }

    public static ExtentTest getTest()
    {
        return parentTest;
    }

    public static void startTest(String testName)
    {
       parentTest = extent.createTest(testName);
    }

    public static void logPassWithScreenshot(String message) {
        if (parentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            parentTest.log(Status.PASS,message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Pass", message);
        }
    }
    public static void logPassWithScreenshot(String message,String []category) {
        if (parentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            parentTest.log(Status.PASS,message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            parentTest.assignCategory(category);
            updateTestSummary("Pass", message);
        }
    }

    public static String captureScreenshotAsBase64() {
        WebDriver driver = threadDriver.get();
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Cannot capture screenshot.");
        }
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }

    public static void logInfoWithScreenshot(String message) {
        if (parentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            parentTest.log(Status.INFO,message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Info", message);
        }
    }

    public static void logFailWithScreenshot(String message) {
        if (parentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            parentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            updateTestSummary("Fail", message);
        }
    }


    public static void logFailWithScreenshot(String message,String []category) {
        if (parentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            parentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            parentTest.assignCategory(category);
            updateTestSummary("Fail", message);
        }
    }

    public static void attachScreenshot(String base64Screenshot) {
        if (parentTest != null) {
            parentTest.addScreenCaptureFromBase64String(base64Screenshot);
        }
    }

    private static void updateTestSummary(String status, String message) {
        String testName = parentTest.getModel().getName();
        List<Map<String, String>> summaries = testSummary.getOrDefault(testName, new ArrayList<>());

        Map<String, String> stepDetails = new HashMap<>();
        stepDetails.put("ID", String.valueOf(summaries.size() + 1));
        stepDetails.put("TestStep", message);
        stepDetails.put("Status", status);
        stepDetails.put("Timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        summaries.add(stepDetails);
        testSummary.put(testName, summaries);
    }


    public static void addTestSummaryTable() {
        if (parentTest != null) {
            String testName = parentTest.getModel().getName();
            List<Map<String, String>> summaries = testSummary.get(testName);

            String tableHtml = "<table style='width:100%; border-collapse: collapse;'>" +
                    "<tr style='background-color: #f2f2f2;'>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>ID</th>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>Test Step</th>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>Status</th>" +
                    "<th style='border: 1px solid #ddd; padding: 8px;'>Timestamp</th>" +
                    "</tr>";

            for (Map<String, String> details : summaries) {
                tableHtml += String.format(
                        "<tr>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "<td style='border: 1px solid #ddd; padding: 8px;'>%s</td>" +
                                "</tr>",
                        details.get("ID"), details.get("TestStep"), details.get("Status"), details.get("Timestamp")
                );
            }
            tableHtml += "</table>";

         parentTest.info("Test Summary").info(tableHtml);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}