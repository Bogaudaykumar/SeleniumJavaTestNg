package Pages;

import Actions.WebActions;
import Reports.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static DriverFactory.BaseTest.threadDriver;

public class AddToCartPage {


static WebElement cartitem;
static   WebElement verification;
    static ExcelReader reader ;
    public  static void initilize(){
        reader = new ExcelReader(".\\src\\main\\resources\\readData.xlsx");
    }
    public static void setAddtocart(WebDriver driver) {
             List<WebElement> addtocart=driver.findElements(By.xpath("//button[text()='Add to cart']"));
            for(WebElement cart:addtocart)
            {
                WebActions.scrollIntoView(driver,cart);
                cart.click();
                ExtentReportManager.logInfoWithScreenshot("Selecting each cart item ");

            }
        }
        public static void setClickCartitems(WebDriver driver) throws IOException {
            Map<String, String> values = reader.getKeyValuePair("login", "cartitem");
            cartitem = WebActions.findElement( driver, values);
            WebActions.scrollIntoView( driver,cartitem);
            cartitem.click();
            ExtentReportManager.logInfoWithScreenshot("Click on add to cart and cart items are ");
        }
        public static String getConfirmationMessage(WebDriver driver) throws IOException {
            Map<String, String> values = reader.getKeyValuePair("login", "verification");
            verification = WebActions.findElement( driver, values);
            ExtentReportManager.logInfoWithScreenshot("Verifying add to cart details");
            return verification.getText();
        }

    }



