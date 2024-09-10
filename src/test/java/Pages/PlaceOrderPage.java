package Pages;

import Actions.WebActions;
import Reports.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelReader;

import java.io.IOException;
import java.util.Map;

public class PlaceOrderPage {
    static WebElement checkout;
    static WebElement firstname;
    static WebElement lastname;
    static WebElement postalcode;
    static WebElement Continue;
    static WebElement verifyOrderdetails;
    static WebElement clickFinish;
    static WebElement verifyPlaceorder;
    static ExcelReader   reader;
    public static void initilize(){
        reader = new ExcelReader(".\\src\\main\\resources\\readData.xlsx");
    }

    public static void enterFirstname(WebDriver driver)throws Exception {

        Map<String, String> values = reader.getKeyValuePair("login", "firstname");
        firstname = WebActions.findElement(driver, values);
        firstname.sendKeys("uday");
    }

    public static String setVerifyPlaceorder(WebDriver driver)throws Exception {
        Map<String, String> values = reader.getKeyValuePair("login", "verifyPlaceorder");
        verifyPlaceorder = WebActions.findElement(driver, values);
        return verifyPlaceorder.getText();
    }

    public static void enterLastname(WebDriver driver)throws Exception {
        Map<String, String> values = reader.getKeyValuePair("login", "lastname");
        lastname = WebActions.findElement(driver, values);
        lastname.sendKeys("kumar");
    }

    public static void enterPostalcode(WebDriver driver)throws Exception {
        Map<String, String> values = reader.getKeyValuePair("login", "postalcode");
        postalcode = WebActions.findElement(driver, values);
        postalcode.sendKeys("565678");
    }

    public static void continueFlow(WebDriver driver) throws IOException {
        Map<String, String> values = reader.getKeyValuePair("login", "Continue");
        Continue = WebActions.findElement(driver, values);
        WebActions.scrollIntoView(driver, Continue);
        Continue.click();

    }

    public static void setClickFinish(WebDriver driver) throws Exception{
        Map<String, String> values = reader.getKeyValuePair("login", "clickFinish");
        clickFinish = WebActions.findElement(driver, values);
        WebActions.scrollIntoView(driver, clickFinish);
        clickFinish.click();
    }

    public static String setVerifyOrderdetails(WebDriver driver)throws Exception {
        Map<String, String> values = reader.getKeyValuePair("login", "verifyOrderdetails");
        verifyOrderdetails = WebActions.findElement(driver, values);
        return verifyOrderdetails.getText();
    }

    public static void setCheckout(WebDriver driver) throws Exception{
        Map<String, String> values = reader.getKeyValuePair("login", "checkout");
        checkout = WebActions.findElement(driver, values);
        WebActions.scrollIntoView(driver, checkout);
        checkout.click();
    }


}
