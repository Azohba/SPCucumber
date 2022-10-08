package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.ClientSideDelayPage;

public class ClientDelayPageSteps {
    ClientSideDelayPage clientDelayPage = new ClientSideDelayPage();

    @Then("check success messages")
    public void checkSuccessMessages() {
        clientDelayPage.checkSuccessMessage();
    }

    @And("click {} times to Client Side button")
    public void clickTimesToClientSideButton(String times) {
        clientDelayPage.clickTriggerButton(times);

    }
}
