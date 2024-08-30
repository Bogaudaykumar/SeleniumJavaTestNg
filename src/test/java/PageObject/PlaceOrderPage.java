package PageObject;
import Actions.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage  {
    WebDriver driver;

    public  PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkout;

    @FindBy(id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastname;

    @FindBy(id = "postal-code")
    private WebElement postalcode;

    @FindBy(id = "continue")
    private WebElement Continue;


    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement verifyOrderdetails;

    @FindBy(xpath = "//button[text()='Finish']")
    private WebElement clickFinish;


    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement verifyPlaceorder;

    public void enterFirstname() {
        firstname.sendKeys("uday");
    }
    public String setVerifyPlaceorder() {
        return verifyPlaceorder.getText();
    }
    public void enterLastname() {
        lastname.sendKeys("kumar");
    }
    public void enterPostalcode() {
        postalcode.sendKeys("565678");
    }
    public void continueFlow()
    {
        WebActions.scrollIntoView(driver,Continue);
        Continue.click();
    }
    public void setClickFinish()
    {
        WebActions.scrollIntoView(driver,clickFinish);
        clickFinish.click();
    }
    public String setVerifyOrderdetails()
    {
        return verifyOrderdetails.getText();
    }
    public void setCheckout() {
        WebActions.scrollIntoView(driver,checkout);
        checkout.click();
    }


}
