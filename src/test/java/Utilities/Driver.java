package Utilities;
import org.openqa.selenium.WebDriver;

public class Driver {
    private static Driver instance;
    private final ThreadLocal<WebDriver> threadLocalDriver;
    private Driver() {
        threadLocalDriver = new ThreadLocal<>();
    }
    public static synchronized Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }
    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }
    public void setDriver(WebDriver driverParameter) {
        threadLocalDriver.set(driverParameter);
    }
    public void removeDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
        }
    }
}