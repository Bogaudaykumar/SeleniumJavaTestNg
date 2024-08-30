package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSelection {
    public static WebDriver browserSelection(String browser,String url){
        WebDriver driver;
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            return driver;
        }
        if(browser.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            return driver;
        }
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}
