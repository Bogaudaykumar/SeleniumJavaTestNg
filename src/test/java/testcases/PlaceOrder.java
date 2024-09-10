package testcases;

import DriverFactory.BaseTest;
import Pages.LoginPage;
import listeners.retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AddToCartPage;
import Pages.PlaceOrderPage;

public class  PlaceOrder extends BaseTest {
    @Test(retryAnalyzer = retry.class)
        public void Placeordertestcase() throws InterruptedException {
            try {
                LoginPage.initilize();
                LoginPage.enterUsername(getDriver(), properties.getProperty("username"));
                LoginPage.enterPassword(getDriver(), properties.getProperty("password"));
                LoginPage.login(getDriver());
                String verifyLoginAssertion = LoginPage.getConfirmationMessage(getDriver());
                Assert.assertEquals(verifyLoginAssertion, "Products", "Login failed!");
                AddToCartPage.initilize();
                AddToCartPage.setAddtocart(getDriver());
                AddToCartPage.setClickCartitems(getDriver());
                String verify= AddToCartPage.getConfirmationMessage(getDriver());
                if(verify.equalsIgnoreCase("Your Cart"))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
                PlaceOrderPage.initilize();
                PlaceOrderPage.setCheckout(getDriver());
                PlaceOrderPage.enterFirstname(getDriver());
                PlaceOrderPage.enterLastname(getDriver());
                PlaceOrderPage.enterPostalcode(getDriver());
                PlaceOrderPage.continueFlow(getDriver());
                if( PlaceOrderPage.setVerifyOrderdetails(getDriver()).equalsIgnoreCase("Checkout: Overview"))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }

                PlaceOrderPage.setClickFinish(getDriver());
                if((PlaceOrderPage.setVerifyPlaceorder(getDriver())).equalsIgnoreCase("Thank you for your order"))
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


