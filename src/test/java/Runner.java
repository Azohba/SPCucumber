import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {"pretty","junit:target/cucumber-results.xml","json:reports/cucumber-results.json"})
public class Runner {

}