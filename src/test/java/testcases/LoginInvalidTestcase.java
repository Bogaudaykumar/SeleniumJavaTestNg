package testcases;/*package testcases;
import DriverFactory.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
//import utilities.DataProvider;
import PageObject.LoginPage;
import utilities.DataProviderClass;
import PageObject.LoginPage;
public class LoginInvalidTestcase extends BaseTest {
    //    @Test(dataProvider = "LoginData", dataProviderClass = TestDataProvider.class)
    // @Test(groups = {"master", "regression"})
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
    public void LoginTestcase1(String username,String password) throws InterruptedException {
        try {
            LoginPage.enterUsername(getDriver(),properties.getProperty("username"));
            LoginPage.enterPassword(getDriver(),properties.getProperty("password"));
            LoginPage.login(getDriver());
            String verifyLoginAssertion = LoginPage.getInvalidConfirmationMessage(getDriver());
            Assert.assertTrue(verifyLoginAssertion.contains("Epic"));
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}


*/

import DriverFactory.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.JsonReader;

public class LoginInvalidTestcase extends BaseTest {
    //    @Test(dataProvider = "LoginData", dataProviderClass = TestDataProvider.class)
    // @Test(groups = {"master", "regression"})
    @Test(dataProvider = "getJsonTestData",dataProviderClass = JsonReader.class)
    public void LoginTestcase1(String username, String password) throws InterruptedException {
        try {
            LoginPage.enterUsername(getDriver(),username);
            LoginPage.enterPassword(getDriver(), password);
            LoginPage.login(getDriver());
            String verifyLoginAssertion = LoginPage.getInvalidConfirmationMessage(getDriver());
            Assert.assertTrue(verifyLoginAssertion.contains("Epic"));
        } catch (Exception e) {
            Assert.assertTrue(false);
        }

    }
}
