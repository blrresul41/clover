package Steps;

import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps extends Base_StepDefinitions {
    @Given("User navigate to search page")
    public void user_navigate_to_search_page() {
        Driver.getInstance().getDriver().get("https://www.google.com/");
    }
    @When("User enters  {string} and clicks Enter")
    public void user_enters_and_clicks_enter(String searchKeyword) {
     searchPage.searchInputBox.sendKeys(searchKeyword, Keys.ENTER);
    }
    @Then("User able to see {string} in the search response")
    public void user_able_to_see_in_the_search_response(String expectedSearchKeyword) {

       List<String>actualSearchList=new ArrayList<>();
       for (WebElement each:searchPage.searchItems) {
          actualSearchList.add(each.getText());
       }
       boolean actualResult=actualSearchList.get(0).contains(expectedSearchKeyword);
       Assertions.assertTrue(actualResult);
    }
}
