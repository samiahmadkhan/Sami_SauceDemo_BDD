package stepDefinations;


import com.enums.javascriptExecutorCommands;
import com.factory.driverFactory;
import com.pages.selectorHubPage;
import com.utility.generalActionsUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class selectorHubStepDef {
    selectorHubPage sp=new selectorHubPage(driverFactory.getDriver());
    generalActionsUtility general=new generalActionsUtility(driverFactory.getDriver());
    @Given("User is on SelectorHub HomePage")
    public void user_is_on_selector_hub_home_page() {
        // Write code here that turns the phrase above into concrete actions
        sp.getPageTitle();
        Assert.assertTrue(sp.getPageTitle().contains("Xpath Practice Page"),"String does not Contains the Expected Text");


    }
    @When("User enter Text in Disabled Field")
    public void user_enter_text_in_disabled_field() {
        // Write code here that turns the phrase above into concrete actions
        //String query="document.querySelector('input[placeholder=\"First Enter name\"]').disabled=false";
      String query= javascriptExecutorCommands.EnableTextField.getQuery().replaceAll("#","input[placeholder=\"First Enter name\"]");
        general.enterTextInDisabledField(query,"Hellow",sp.firstName_disabledTextbox);
    }

}
