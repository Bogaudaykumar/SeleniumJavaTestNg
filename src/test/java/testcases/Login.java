package testcases;

import DriverFactory.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import utilities.ExcelReader;


public class Login extends BaseTest {
    @Test(groups = {"sanity"}, description = "Verify and validate whether the user is able to login with valid credentials")
    public void LoginTestcase1() {
        try {
            LoginPage.initilize();
            LoginPage.enterUsername(getDriver(),properties.getProperty("username"));
            LoginPage.enterPassword(getDriver(),properties.getProperty("password"));
            LoginPage.login(getDriver());
            String verifyLoginAssertion = LoginPage.getConfirmationMessage(getDriver());
            Assert.assertEquals(verifyLoginAssertion, "Products", "Login confirmation message does not match.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
