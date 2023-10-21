package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.factory.driverFactory;
import com.pages.loginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class loginPageStepDef {
	
	private loginPage loginpage=new loginPage(driverFactory.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		String ActualTitle=loginpage.getPageTitle();
		Assert.assertEquals(ActualTitle,"Swag Labs" );
	}

	@When("User enters username and password")
	public void user_enters_and(DataTable dataTable) {
		List<Map<String, String>> data= dataTable.asMaps(String.class,String.class);
		String username=data.get(0).get("username");
		String password=data.get(0).get("password");
		
		System.out.println("Username and Pass is = "+ username + " and " + password);
	   
	}
}
