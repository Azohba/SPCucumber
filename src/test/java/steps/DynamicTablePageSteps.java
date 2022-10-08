package steps;

import io.cucumber.java.en.Then;
import pageObjects.DynamicTablePage;

public class DynamicTablePageSteps {
    DynamicTablePage dynamicTablePage = new DynamicTablePage();
    @Then("get Chrome Cpu value")
    public void getChromeCpuValue() {
        dynamicTablePage.getCpuValue();
    }
}
