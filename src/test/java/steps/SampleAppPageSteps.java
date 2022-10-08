package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.SampleAppLoginPage;


public class SampleAppPageSteps {
    SampleAppLoginPage sampleAppLoginPage = new SampleAppLoginPage();

    @Then("click Log In button")
    public void clickLogInButton() {
        sampleAppLoginPage.clickLoginButton();
    }

    @Then("^check (successLogin|failedLogin|loggedOut) login status$")
    public void checkLoginStatus(String status) {
        sampleAppLoginPage.checkLoginStatus(status);
    }

    @And("enter {}  and {}")
    public void enterAnd(String name, String pass) {
        sampleAppLoginPage.enterUsernamePassParams(name,pass);
    }
}
