package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.BaseActions;

public class HomePageSteps {
    
    BaseActions baseActions = new BaseActions();
    HomePage homePage = new HomePage();


   @Before
   public void drivers(){
       baseActions.initializeDriver();
   }

   @After
   public void afterScenario(Scenario scenario){
       BaseActions baseActions = new BaseActions();
       if (scenario.isFailed()){
           try {
               baseActions.getScreenShot(scenario.getName() );
           }catch (Exception e){
               System.out.println("Exception while getting SS :   ----" + e.getMessage());
           }
       }
        baseActions.tearDrop();
   }


    @Given("go to homepage")
    public void goToHomepage() {
        baseActions.goToHomepage();
    }


    @When("^click (sampleapp|clientdelay|dynamictable) href link$")
    public void clickHrefLink(String link) {
        homePage.clickHrefLink(link);
    }
}
