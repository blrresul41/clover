package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features/SearchPage.feature",
        glue="Steps",
       tags={"@test"}
)
public class TestRunner {
}