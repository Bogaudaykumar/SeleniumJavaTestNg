package testcases;
import Pages.LoginPage;
import DriverFactory.BaseTest;
import listeners.retry;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AddToCartPage;

public class AddToCart extends BaseTest {
    @Test(groups ={"regression"})
    public void Addtocarttestcase() throws InterruptedException {
        try {
            LoginPage.initilize();
            LoginPage.enterUsername(getDriver(), properties.getProperty("username"));
            LoginPage.enterPassword(getDriver(), properties.getProperty("password"));
            LoginPage.login(getDriver());
            String verifyLoginAssertion = LoginPage.getConfirmationMessage(getDriver());
            Assert.assertEquals(verifyLoginAssertion, "Products");
            AddToCartPage.initilize();
            AddToCartPage.setAddtocart(getDriver());
            AddToCartPage.setClickCartitems(getDriver());
            String verify = AddToCartPage.getConfirmationMessage(getDriver());
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
