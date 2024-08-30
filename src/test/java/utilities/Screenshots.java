package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {
    public static void  takeScreenshot(WebDriver driver, String name) throws Exception {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        TakesScreenshot ts=(TakesScreenshot)driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+name+"_"+timestamp+".png";
        File sc = new File("./Screenshots/");
        File SS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SS, new File(sc , name));
        System.out.println("Screenshot taken succesfull");
    }
}
