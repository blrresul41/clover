package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
        public static WebDriver createInstance() {
            try {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }