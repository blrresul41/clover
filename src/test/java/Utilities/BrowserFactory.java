package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;

public class BrowserFactory {
    static WebDriver driver;
    public static WebDriver createInstance() {
        try {
            if (driver == null) {
                if(System.getProperty("browser")==null){
                    WebDriverManager.chromedriver().setup();
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"/src/test/resources/testData/Downloads");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--ignore-ssl-errors=yes");
                    options.addArguments("--ignore-certificate-errors");
                    options.setExperimentalOption("prefs", chromePrefs);
                    driver = new ChromeDriver(options);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return driver;
    }
}