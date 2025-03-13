package stepDefinations;

import java.util.List;
import java.util.Map;

import com.FactoryNew.DriverManager;
import org.testng.Assert;

import com.factory.driverFactory;
import com.pages.ProductsPage;
import com.pages.loginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPageStepDef {
	
	//private loginPage loginpage=new loginPage(DriverManager.getDriver());
	private loginPage loginpage=new loginPage(DriverManager.getDriver());

	private ProductsPage productPage;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		String ActualTitle=loginpage.getPageTitle();
		Assert.assertEquals(ActualTitle, "Swag Labs", "User Successfully Landed on Swag Labs Page");
		
	}
	//this is duplicate step

//	@Given("User is on login page")
//	public void user_is_on_login_page2() {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("duplicate method");
//
//	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String username,String password) {
		
		System.out.println("Username and Pass is = "+ username + " and " + password);
		productPage=loginpage.login(username, password);
		
		
}
	@Then("User gets {string}")
	public void user_gets_error_message(String errorMessage) {
		 boolean actual=loginpage.verifyErrorMessage(errorMessage);
	     Assert.assertEquals(actual, true,"Verified getting correct Error Message : "+ errorMessage);
	     
	}

//	@When("User enters {String} and {String}")
//	public void user_enters_and(DataTable dataTable) {
//		List<Map<String, String>> data= dataTable.asMaps(String.class,String.class);
//		String username=data.get(0).get("username");
//		String password=data.get(0).get("password");
//		
//		System.out.println("Username and Pass is = "+ username + " and " + password);
//	   
//	}
}
