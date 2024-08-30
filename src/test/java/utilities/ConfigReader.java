package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    public static void configReaderConfiguration() {
        properties = new Properties();
        try {
            String path = System.getProperty("user.dir") + "\\configdata\\Config.properties";
            FileInputStream input = new FileInputStream(path);
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties.");
        }
    }
    public static String getBrowser() {
        return properties.getProperty("browser");
    }


    public static String getUrl() {
        return properties.getProperty("url");
    }
    public static  String getUsername() {
        return properties.getProperty("username");
    }
    public static  String getPassword() {
        return properties.getProperty("password");
    }



}
