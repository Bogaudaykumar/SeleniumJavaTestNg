package PageObject;

import Actions.WebActions;
import Reports.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static DriverFactory.BaseTest.driver1;

public class AddToCartPage {
        public  AddToCartPage() {
        }

        public void setAddtocart() {
             List<WebElement> addtocart=driver1.get().findElements(By.xpath("//button[text()='Add to cart']"));
            for(WebElement cart:addtocart)
            {
                WebActions.scrollIntoView(driver1.get(),cart);
                cart.click();
                ExtentReportManager.logInfoWithScreenshot("Selecting each cart item ");

            }
        }

        public void setClickCartitems() {
            WebElement cartitems=driver1.get().findElement(By.xpath("//a[@class='shopping_cart_link']"));
            WebActions.scrollIntoView(driver1.get(),cartitems);
            cartitems.click();
            ExtentReportManager.logInfoWithScreenshot("Click on add to cart and cart items are ");
        }
        public String getConfirmationMessage(){
            WebElement verifycart=driver1.get().findElement(By.xpath("//span[text()='Your Cart']"));
            ExtentReportManager.logInfoWithScreenshot("Verifying add to cart details");
            return verifycart.getText();
        }
        public void customAddtocart( ExtentTest test){
            try{
                test.info("Adding items to cart");
                setAddtocart();
                test.info("items are added to cart");
                setClickCartitems();
                String verify= getConfirmationMessage();
                if(verify.equalsIgnoreCase("Your Cart"))
                {
                    test.info("Navigated to cart page");
                    Assert.assertTrue(true);
                }
                else{
                    Assert.assertTrue(false);
                }}
            catch (Exception e)
            {
                Assert.assertTrue(false);
            }
        }
        //button[text()='Add to cart']
    }



