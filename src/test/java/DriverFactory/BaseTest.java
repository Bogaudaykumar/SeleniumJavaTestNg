package DriverFactory;

import Reports.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ISuite;
import org.testng.annotations.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.*;
import java.time.Duration;
import java.util.*;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
    public static Properties properties = new Properties();
    public static FileReader fileReader;
    private static String USER_NAME = "bogaudaykumar75@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "UdayBoga@123"; // GMail password
    private static String RECIPIENT = "bogaudaykumar75@gmail.com";

    public static void setProperties(){
        try {
            fileReader = new FileReader("./src/test/java/Configfiles/Config.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file.", e);
        }
    }

    public static WebDriver browserSelection(String browser, String url) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static WebDriver getDriver() {
        return driver1.get();
    }

    public static void setDriver(String browser, String url) {
        driver1.set(browserSelection(browser, url));
    }

    public static void driverDropping() {
        if (driver1.get() != null) {
            driver1.get().quit();
        }
        driver1.remove();
    }


    }

