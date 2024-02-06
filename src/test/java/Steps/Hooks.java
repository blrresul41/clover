package Steps;

import Utilities.BrowserFactory;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
public class Hooks  {
    @Before
    public void setUp() {
        WebDriver driver = BrowserFactory.createInstance();
        Driver.getInstance().setDriver(driver);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        Driver.getInstance().removeDriver();
    }
}