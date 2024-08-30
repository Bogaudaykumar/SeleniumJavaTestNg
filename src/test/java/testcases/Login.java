package testcases;

import DriverFactory.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.LoginPage;

public class Login extends BaseTest {
    @Test
    public void LoginTestcase1() {
        try {
            LoginPage loginPage = new LoginPage();
            loginPage.enterUsername(properties.getProperty("username"));
            loginPage.enterPassword(properties.getProperty("password"));
            loginPage.login();
            String verifyLoginAssertion = loginPage.getConfirmationMessage();
            Assert.assertEquals(verifyLoginAssertion, "Products", "Login confirmation message does not match.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
