/*
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



        public static void email() {
            String from = USER_NAME;
            String pass = PASSWORD;
            String[] to = { RECIPIENT }; // list of recipient email addresses
            String subject = "Java send mail example";
            String body = "Welcome to JavaMail!";

            sendFromGMail(from, pass, to, subject, body);
        }

        private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(from));
                InternetAddress[] toAddress = new InternetAddress[to.length];

                // To get the array of addresses
                for( int i = 0; i < to.length; i++ ) {
                    toAddress[i] = new InternetAddress(to[i]);
                }

                for( int i = 0; i < toAddress.length; i++) {
                    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
                }

                message.setSubject(subject);
                message.setText(body);
                Transport transport = session.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            catch (AddressException ae) {
                ae.printStackTrace();
            }
            catch (MessagingException me) {
                me.printStackTrace();
            }
        }
    }

*/
package DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import static mail.gmail.sendEmail;
public class BaseTest {
    public static Properties properties;
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void configReader() throws Exception {
        properties = new Properties();
        FileInputStream FI = new FileInputStream("src/main/resources/Config.properties");
        properties.load(FI);
    }

    public static void browserSelection(String browser, String url) throws Exception {
        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new EdgeDriver();
                break;
            case "docker":
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        threadDriver.set(driver);
        driver = threadDriver.get();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void driverDropping() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
        }
        if (threadDriver != null) {
            threadDriver.remove();
        }
    }
}