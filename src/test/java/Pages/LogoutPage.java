package Pages;

/*package PageObject;
import Actions.WebActions;
import Reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static DriverFactory.BaseTest.threadDriver;
public class LoginPage {
    static WebElement username;
    static WebElement password;
    static WebElement login;
    static WebElement clickMenu;
    static WebElement logout;
    static WebElement verifyInvalidLogin;
    static WebElement verifyLogin;

    public static void enterUsername(WebDriver driver,String id) {
        username=driver.findElement(By.xpath("(//input[@class=\"input_error form_input\"])[1]"));
        username.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("username is entered");
    }

    public static void enterPassword(WebDriver driver,String id) {
        password=driver.findElement(By.xpath("(//input[@class=\"input_error form_input\"])[2]"));
        password.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("password is entered");

    }

    public static void login(WebDriver driver) {
        login=driver.findElement(By.xpath("//input[@class=\"submit-button btn_action\"]"));
        login.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on login button");

    }

    public static void clickMenu(WebDriver driver) {
        clickMenu=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        clickMenu.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on hamburger icon");

    }

    public static void logout(WebDriver driver) {
        logout=driver.findElement(By.xpath("//a[@class=\"bm-item menu-item\"][3]"));
        logout.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on logout");

    }

    public static String getConfirmationMessage(WebDriver driver) throws InterruptedException {
        try {
            verifyLogin=driver.findElement(By.xpath("//span[@class=\"title\"]"));
            WebActions webActions=new WebActions(threadDriver.get());
            WebActions.moveToElement(verifyLogin);
            ExtentReportManager.logInfoWithScreenshot("verify login by products tag ");
            return verifyLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public static String getInvalidConfirmationMessage(WebDriver driver) throws InterruptedException {
        try {
            verifyInvalidLogin=driver.findElement(By.tagName("h3"));
            ExtentReportManager.logInfoWithScreenshot("invalid login ");
            return verifyInvalidLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    */
//    public void customLogin(Properties properties, ExtentTest test){
//        try {
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.enterUsername(properties.getProperty("username"));
//            test.info("username is entered");
//            loginPage.enterPassword(properties.getProperty("password"));
//            test.info("password is entered");
//            loginPage.login();
//            String verifyloginassertion=loginPage.getConfirmationMessage();
//            if(verifyloginassertion.equals("Products"))
//            {
//                test.info("Logged in");
//                test.info("Navigated to products page");
//
//                Assert.assertTrue(true);
//            }
//            else {
//                Assert.assertTrue(false);
//
//            }
//        }
//        catch(Exception e)
//        {
//            Assert.fail();
//        }
//    }
// public boolean isProductsDisplayed() throws InterruptedException {
//        try{
//            return (verifyLogin.isDisplayed());
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }

/*
package PageObject;
import Actions.WebActions;
import Reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ExcelReader;

import static DriverFactory.BaseTest.threadDriver;
public class LoginPage {
    static WebElement username;
    static WebElement password;
    static WebElement login;
    static WebElement clickMenu;
    static WebElement logout;
    static WebElement verifyInvalidLogin;
    static WebElement verifyLogin;
    static String filePath = ".\\src\\test\\java\\testcases\\readData.xlsx";
    static String sheetName = "login";
    public static void enterUsername(WebDriver driver,String id)
    {
        String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 2);
        username=driver.findElement(By.xpath(xPath));
        username.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("username is entered");
    }

    public static void enterPassword(WebDriver driver,String id)
    {
        String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 4);
        password=driver.findElement(By.xpath(xPath));
        password.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("password is entered");

    }

    public static void login(WebDriver driver) {
        String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 5);
        login=driver.findElement(By.xpath(xPath));
        login.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on login button");

    }

    public static void clickMenu(WebDriver driver) {
        String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 6);
        clickMenu=driver.findElement(By.xpath(xPath));
        clickMenu.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on hamburger icon");

    }

    public static void logout(WebDriver driver) {
        String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 7);
        logout=driver.findElement(By.xpath(xPath));
        logout.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on logout");

    }

    public static String getConfirmationMessage(WebDriver driver) throws InterruptedException {
        try {
            String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 8);
            verifyLogin=driver.findElement(By.xpath(xPath));
            WebActions webActions=new WebActions(threadDriver.get());
            WebActions.moveToElement(verifyLogin);
            ExtentReportManager.logInfoWithScreenshot("verify login by products tag ");
            return verifyLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String getInvalidConfirmationMessage(WebDriver driver) throws InterruptedException {
        try {
            String xPath = ExcelReader.getCellData(filePath, sheetName, 2, 9);
            verifyInvalidLogin=driver.findElement(By.tagName(xPath));
            ExtentReportManager.logInfoWithScreenshot("invalid login ");
            return verifyInvalidLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }}

*/
//    public void customLogin(Properties properties, ExtentTest test){
//        try {
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.enterUsername(properties.getProperty("username"));
//            test.info("username is entered");
//            loginPage.enterPassword(properties.getProperty("password"));
//            test.info("password is entered");
//            loginPage.login();
//            String verifyloginassertion=loginPage.getConfirmationMessage();
//            if(verifyloginassertion.equals("Products"))
//            {
//                test.info("Logged in");
//                test.info("Navigated to products page");
//
//                Assert.assertTrue(true);
//            }
//            else {
//                Assert.assertTrue(false);
//
//            }
//        }
//        catch(Exception e)
//        {
//            Assert.fail();
//        }
//    }
// public boolean isProductsDisplayed() throws InterruptedException {
//        try{
//            return (verifyLogin.isDisplayed());
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }
/*
package PageObject;
import Actions.WebActions;
import Reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ExcelReader;
import java.io.IOException;
import static DriverFactory.BaseTest.threadDriver;

public class LoginPage {
    static WebElement username;
    static WebElement password;
    static WebElement login;
    static WebElement clickMenu;
    static WebElement logout;
    static WebElement verifyInvalidLogin;
    static WebElement verifyLogin;
    static ExcelReader reader;
    public static void initialize() throws IOException {
        reader = new ExcelReader(".\\src\\test\\java\\testcases\\readData.xlsx");
    }

    public static void enterUsername(WebDriver driver, String id) throws IOException {
        String path =reader.getCellDataByReference("login", "A2");;
        System.out.println("Username XPath: " +path);
        WebElement username = driver.findElement(By.xpath(path));
        username.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("username is entered");
    }

    public static void enterPassword(WebDriver driver, String id) throws IOException {
        String path =reader.getCellDataByReference("login", "B2");;
        System.out.println("Password XPath: " + path);
        WebElement password = driver.findElement(By.xpath(path));
        password.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("password is entered");
    }

    public static void login(WebDriver driver) throws IOException{
        String path =reader.getCellDataByReference("login", "C2");;
        login = driver.findElement(By.xpath(path));
        login.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on login button");
    }

    public static void clickMenu(WebDriver driver)throws IOException {
        String path =reader.getCellDataByReference("login", "D2");;
        clickMenu = driver.findElement(By.xpath(path));
        clickMenu.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on hamburger icon");
    }

    public static void logout(WebDriver driver)throws IOException {
        String path =reader.getCellDataByReference("login", "E2");;
        logout = driver.findElement(By.xpath(path));
        logout.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on logout");
    }

    public static String getConfirmationMessage(WebDriver driver) throws InterruptedException {
        try {
            String path =reader.getCellDataByReference("login", "F2");;
            verifyLogin = driver.findElement(By.xpath(path));
            WebActions webActions = new WebActions(threadDriver.get());
            WebActions.moveToElement(verifyLogin);
            ExtentReportManager.logInfoWithScreenshot("verify login by products tag");
            return verifyLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String getInvalidConfirmationMessage(WebDriver driver) throws InterruptedException {
        try {
            String path =reader.getCellDataByReference("login", "G2");
            verifyInvalidLogin = driver.findElement(By.xpath(path));
            ExtentReportManager.logInfoWithScreenshot("invalid login ");
            return verifyInvalidLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

*/


import Actions.WebActions;
import Reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ExcelReader;

import java.io.IOException;
import java.util.Map;

import static DriverFactory.BaseTest.threadDriver;

public class LogoutPage {

    static WebElement clickMenu;
    static WebElement logout;
    static ExcelReader reader;

    public static void initilize(){
         reader = new ExcelReader(".\\src\\main\\resources\\readData.xlsx");

    }

    public static void clickMenu(WebDriver driver) throws IOException {
        Map<String, String> values = reader.getKeyValuePair("login", "clickMenu");
        clickMenu =WebActions.findElement(driver, values);
        clickMenu.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on hamburger icon");
    }

    public static void logout(WebDriver driver) throws IOException {
        Map<String, String> values = reader.getKeyValuePair("login", "logout");
        logout = WebActions.findElement(driver, values);
        logout.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on logout");
    }

}