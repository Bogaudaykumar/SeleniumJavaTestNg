package testcases;

import DriverFactory.BaseTest;
import Pages.LoginPage;
import Pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends BaseTest {
    @Test(groups = {"sanity"}, description = "Verify and validate whether the user is able to login with invalid credentials")
    public void LogoutTestcase() {
        try {
            LoginPage.initilize();
            LoginPage.enterUsername(getDriver(),properties.getProperty("username"));
            LoginPage.enterPassword(getDriver(),properties.getProperty("password"));
            LoginPage.login(getDriver());
            String verifyLoginAssertion = LoginPage.getConfirmationMessage(getDriver());
            Assert.assertEquals(verifyLoginAssertion, "Products", "Login confirmation message does not match.");
            LogoutPage.initilize();
            LogoutPage.clickMenu(getDriver());
            LogoutPage.logout(getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}