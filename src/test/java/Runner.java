import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.Calliope;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {"pretty","junit:reports/cucumber-results.xml","json:reports/cucumber-results.json"})
public class Runner {

    @AfterClass
    public static void sent() throws IOException{
        Calliope calliope = new Calliope();
        calliope.sendHTTPReq();
    }

}