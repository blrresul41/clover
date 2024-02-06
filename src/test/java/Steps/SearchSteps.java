package Steps;


import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchSteps extends Base_StepDefinitions {
    Duration timeout = Duration.ofSeconds(10);

    @Given("User navigate to {string} search page")
    public void user_navigate_to_search_page(String searchEngine) {
        if (searchEngine.equalsIgnoreCase("Google")) {
            Driver.getInstance().getDriver().get("https://www.google.com/");
        } else if (searchEngine.equalsIgnoreCase("Yahoo")) {
            Driver.getInstance().getDriver().get("https://www.yahoo.com/");
        } else if (searchEngine.equalsIgnoreCase("Bing")) {
            Driver.getInstance().getDriver().get("https://www.bing.com/");
        }
    }
    @When("User enters {string} and clicks enter on {string}")
    public void userEntersAndClicksEnterOn(String searchItem, String searchEngine) throws InterruptedException {
        WebDriver driver = Driver.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        switch (searchEngine.toLowerCase()) {
            case "google":
                searchPage.googleSearchBox.sendKeys(searchItem, Keys.ENTER);
                break;
            case "bing":
                Thread.sleep(5000);
                searchPage.bingSearchBox.sendKeys(searchItem, Keys.ENTER);
                break;
            case "yahoo":
                searchPage.yahooSearchbox.sendKeys(searchItem, Keys.ENTER);
                break;
            default:
                System.out.println("Unsupported search engine: " + searchEngine);
                break;
        }
    }
    @Then("User able to see {string} in the search response on {string}")
    public void userAbleToSeeInTheSearchResponseOn(String expectedSearchKeyword, String searchEngine) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(),timeout); // Adjust the timeout as needed
        Driver.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<String> actualSearchList = new ArrayList<>();
        for (WebElement each : searchPage.searchItems) {
            actualSearchList.add(each.getText());
        }
        boolean actualResult = actualSearchList.get(0).contains(expectedSearchKeyword);

        switch (searchEngine.toLowerCase()) {
            case "google":
            case "bing":
            case "yahoo":
                Assertions.assertTrue(actualResult);
                break;
            default:
                throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
        }
    }
}

