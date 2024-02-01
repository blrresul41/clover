package Steps;

import Utilities.BrowserFactory;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Hooks {
    public WebDriver driver=null;
    @Before
    public void setUp(){
        driver= BrowserFactory.createInstance();
        Duration timeout =Duration.ofSeconds(10);
        long timeoutInMillis = timeout.toMillis();
        try {
            Driver.getInstance().setDriver(driver);
            driver = Driver.getInstance().getDriver();
            driver.manage().timeouts().implicitlyWait(timeoutInMillis,TimeUnit.MILLISECONDS);
        } catch (NoSuchSessionException e) {
            driver.quit();
            Driver.getInstance().setDriver(driver);
            driver = Driver.getInstance().getDriver();
            driver.manage().timeouts().implicitlyWait(timeoutInMillis,TimeUnit.MILLISECONDS);
        }
    }
    @After
    public void tearDown() {
        Driver.getInstance().removeDriver();
    }
}