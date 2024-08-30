package Reports;

import DriverFactory.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static DriverFactory.BaseTest.driver1;
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
public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest extentTest;

    public static void reportConfiguration(String testName) {
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

        extentTest = extent.createTest(testName);
    }

    public static ExtentTest getTest() {
        return extentTest;
    }

    public static void logPassWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }

    public static String captureScreenshotAsBase64() {
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver1.get();
        return takesScreenshot.getScreenshotAs(OutputType.BASE64);
    }
    public static void logInfoWithScreenshot(String message) {
        if (extentTest != null) {
        String base64Screenshot = captureScreenshotAsBase64();
        extentTest.info(message,com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }
    }

    public static void logFailWithScreenshot(String message) {
        if (extentTest != null) {
            String base64Screenshot = captureScreenshotAsBase64();
            extentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
    public static void attachScreenshot(String base64Screenshot) {
        extentTest.addScreenCaptureFromBase64String(base64Screenshot);
    }
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

}
