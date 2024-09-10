package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class WebActions {
    static Actions action;
    static HashMap<Integer, String> hm = new HashMap<>();
    public static WebElement findElement(WebDriver driver, Map<String, String> values) {
        String locatorValue = values.get("value");
        String locatorType = values.get("locatorType");
        switch (locatorType.toLowerCase()) {
            case "xpath":
                return driver.findElement(By.xpath(locatorValue));
            case "id":
                return driver.findElement(By.id(locatorValue));
            case "name":
                return driver.findElement(By.name(locatorValue));
            case "classname":
                return driver.findElement(By.className(locatorValue));
            case "tagname":
                return driver.findElement(By.tagName(locatorValue));
            case "cssselector":
                return driver.findElement(By.cssSelector(locatorValue));
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }

    public static void moveToElement(WebDriver driver,WebElement element) {
        action=new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public static void selectByValue(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByValue(text);
    }
    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}





/*package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class WebActions {
    private static WebDriver driver;
    private WebDriverWait wait;
    static Actions action;
    static HashMap<Integer, String> hm = new HashMap<>();

    public WebActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //generic methods..................................................

    public static WebElement findElement(WebDriver driver, Map<String, String> values) {
        String locatorValue = values.get("value");
        String locatorType = values.get("locatorType");

        switch (locatorType.toLowerCase()) {
            case "xpath":
                return driver.findElement(By.xpath(locatorValue));
            case "id":
                return driver.findElement(By.id(locatorValue));
            case "name":
                return driver.findElement(By.name(locatorValue));
            case "classname":
                return driver.findElement(By.className(locatorValue));
            case "tagname":
                return driver.findElement(By.tagName(locatorValue));
            case "cssselector":
                return driver.findElement(By.cssSelector(locatorValue));
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }
    public void sendTextWhenVisible(WebDriver driver, By locator, String text, int timeInSeconds) {
        WebElement element = waitForElementToBeVisible(driver, locator, timeInSeconds);
        element.sendKeys(text);
    }

    public String getTextFromElement(WebDriver driver, By locator) {
        return driver.findElement(locator).getText();
    }

    public void sendTextToElement(WebDriver driver, By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clickElement(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
    public WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void setImplicitWait(WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }


    //mouse actions---------------------------------------------------------------------------
    public static void moveToElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    public static void scrollToElement(WebElement element) {
        action.scrollToElement(element).perform();
    }

    public static void dragAndDropBy(WebElement element, int x, int y) {
        action.dragAndDropBy(element, x, y).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        action.dragAndDrop(source, target).perform();
    }

    public static void doubleClick(WebElement element) {
        action.doubleClick(element).perform();
    }

    public static void rightClick(WebElement element) {
        action.contextClick(element).perform();
    }

    public static void clickAndHold(WebElement element) {
        action.clickAndHold(element).perform();
    }

    public static void release(WebElement element) {
        action.release(element).perform();
    }

    //dropdown handling using select class------------------------------------------------------
    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static List<WebElement> getAllOptions(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    //frames handling--------------------------------------------------------------------------
    public static void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    //window handling---------------------------------------------------------------------------
    public static void switchToNewWindow(String window) {
        driver.switchTo().window(window);
    }

    public static String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public static void windowHandling(int window, String s) {
        hm.put(window, s);
    }

    public static void windowNavigation2(String s) {
        Set<String> set = driver.getWindowHandles();
        for (String st : set) {
            if (!st.equals(s)) {
                driver.switchTo().window(st);
                break;
            }
        }
    }

    public static void windowNavigation(int window) {
        Set<String> set = driver.getWindowHandles();
        for (String st : set) {
            if (st.equals(hm.get(window))) {
                driver.switchTo().window(st);
                break;
            }
        }
    }

    //alerts handling----------------------------------------------------------------------------
    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public static void sendKeysToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    //keyboard actions------------------------------------------------------------------------------
    public static void selectAllText() {
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    }

    public static void copyText() {
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
    }

    public static void pasteText() {
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    public static void pageDown() {
        action.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public static void pageUp() {
        action.sendKeys(Keys.PAGE_UP).perform();
    }

    public static void pressEnter() {
        action.sendKeys(Keys.ENTER).perform();
    }

    public static void pressTab() {
        action.sendKeys(Keys.TAB).perform();
    }

    public static void pressEscape() {
        action.sendKeys(Keys.ESCAPE).perform();
    }

    //javascript methods
    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToTop(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }

    public static String getInnerTextByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].innerText;", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String style) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='" + style + "';", element);
    }

    public static void triggerAlert(WebDriver driver, String message) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("alert(arguments[0]);", message);
    }

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.title;");
    }

    public static String getUrlByJS(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.URL;");
    }


}
*/