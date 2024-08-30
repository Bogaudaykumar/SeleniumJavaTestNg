package testcases;

import PageObject.LoginPage;
import DriverFactory.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.AddToCartPage;

public class AddToCart extends BaseTest {
    @Test()
    public void Addtocarttestcase() throws InterruptedException {
        try {
            LoginPage loginPage = new LoginPage();
            AddToCartPage addtocartPage = new AddToCartPage();
            loginPage.enterUsername(properties.getProperty("username"));
            loginPage.enterPassword(properties.getProperty("password"));
            loginPage.login();
            String verifyLoginAssertion = loginPage.getConfirmationMessage();
            Assert.assertEquals(verifyLoginAssertion, "Products");
            addtocartPage.setAddtocart();
            addtocartPage.setClickCartitems();
            String verify = addtocartPage.getConfirmationMessage();
            if (verify.equalsIgnoreCase("Your Cart")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
