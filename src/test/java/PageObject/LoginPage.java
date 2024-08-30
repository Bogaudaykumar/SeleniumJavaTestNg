package PageObject;
import Actions.WebActions;
import Reports.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static DriverFactory.BaseTest.driver1;
public class LoginPage {

    public LoginPage(){}
    public void enterUsername(String id) {
         WebElement username=driver1.get().findElement(By.xpath("(//input[@class=\"input_error form_input\"])[1]"));
        username.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("username is entered");
    }

    public void enterPassword(String id) {
      WebElement password=driver1.get().findElement(By.xpath("(//input[@class=\"input_error form_input\"])[2]"));
        password.sendKeys(id);
        ExtentReportManager.logInfoWithScreenshot("password is entered");

    }

    public void login() {
        WebElement loginButton=driver1.get().findElement(By.xpath("//input[@class=\"submit-button btn_action\"]"));
        loginButton.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on login button");

    }

    public void clickHamburger() {
        WebElement hamburger=driver1.get().findElement(By.xpath("//button[@id='react-burger-menu-btn']"));

        hamburger.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on hamburger icon");

    }

    public void clickLogout() {
        WebElement logout=driver1.get().findElement(By.xpath("//a[@class=\"bm-item menu-item\"][3]"));

        logout.click();
        ExtentReportManager.logInfoWithScreenshot("clicked on logout");

    }

    public String getConfirmationMessage() throws InterruptedException {
        try {
            WebElement verifyLogin=driver1.get().findElement(By.xpath("//span[@class=\"title\"]"));

            WebActions webActions=new WebActions(driver1.get());
            WebActions.moveToElement(verifyLogin);
            ExtentReportManager.logInfoWithScreenshot("verify login by products tag ");
            return verifyLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public String getInvalidConfirmationMessage() throws InterruptedException {
        try {
            WebElement verifyInvalidLogin=driver1.get().findElement(By.tagName("h3"));

            ExtentReportManager.logInfoWithScreenshot("invalid login ");
            return verifyInvalidLogin.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
//    public void customLogin(Properties properties, ExtentTest test){
//        try {
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.enterUsername(properties.getProperty("username"));
//            test.info("username is entered");
//            loginPage.enterPassword(properties.getProperty("password"));
//            test.info("password is entered");
//            loginPage.login();
//            String verifyloginassertion=loginPage.getConfirmationMessage();
//            if(verifyloginassertion.equals("Products"))
//            {
//                test.info("Logged in");
//                test.info("Navigated to products page");
//
//                Assert.assertTrue(true);
//            }
//            else {
//                Assert.assertTrue(false);
//
//            }
//        }
//        catch(Exception e)
//        {
//            Assert.fail();
//        }
//    }
    // public boolean isProductsDisplayed() throws InterruptedException {
//        try{
//            return (verifyLogin.isDisplayed());
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//    }


}
