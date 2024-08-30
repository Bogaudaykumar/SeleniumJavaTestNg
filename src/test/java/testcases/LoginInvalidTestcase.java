package testcases;
import DriverFactory.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
//import utilities.DataProvider;
import PageObject.LoginPage;
import utilities.DataProviderClass;

public class LoginInvalidTestcase extends BaseTest {
    //    @Test(dataProvider = "LoginData", dataProviderClass = TestDataProvider.class)
    // @Test(groups = {"master", "regression"})
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
    public void LoginTestcase1(String username,String password) throws InterruptedException {
        try {
            LoginPage loginPage = new LoginPage();
            loginPage.enterUsername((username));
            loginPage.enterPassword((password));
            loginPage.login();
            String verifyLoginAssertion = loginPage.getInvalidConfirmationMessage();
            Assert.assertTrue(verifyLoginAssertion.contains("Epic"));
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}


