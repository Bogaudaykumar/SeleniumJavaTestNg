package testcases;

import DriverFactory.BaseTest;
import PageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.AddToCartPage;
import PageObject.PlaceOrderPage;

public class PlaceOrder extends BaseTest {
    @Test()
        public void Placeordertestcase() throws InterruptedException {
            try {
                LoginPage loginPage=new LoginPage();
                AddToCartPage addtocartPage=new AddToCartPage();
                PlaceOrderPage placeOrderPage=new PlaceOrderPage(driver1.get());
                loginPage.enterUsername(properties.getProperty("username"));
                loginPage.enterPassword(properties.getProperty("password"));
                loginPage.login();
                String verifyLoginAssertion = loginPage.getConfirmationMessage();
                Assert.assertEquals(verifyLoginAssertion, "Products", "Login failed!");
                addtocartPage.setAddtocart();
                addtocartPage.setClickCartitems();
                String verify= addtocartPage.getConfirmationMessage();
                if(verify.equalsIgnoreCase("Your Cart"))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
                placeOrderPage.setCheckout();
                placeOrderPage.enterFirstname();
                placeOrderPage.enterLastname();
                placeOrderPage.enterPostalcode();
                placeOrderPage.continueFlow();
                if( placeOrderPage.setVerifyOrderdetails().equalsIgnoreCase("Checkout: Overview"))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }

                placeOrderPage.setClickFinish();
                if(placeOrderPage.setVerifyPlaceorder().equalsIgnoreCase("Thank you for your order!"))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            } catch (Exception e) {
                Assert.fail();
            }

        }
    }


