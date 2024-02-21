package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.factory.driverFactory;
import com.pages.checkoutPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkoutPageStepDef {
private checkoutPage checkout=new checkoutPage(driverFactory.getDriver());

@When("User Fill following details")
public void user_enter_details(DataTable dataTable) {
	String FirstName;
	String LastName;
	String Postcode;
	
	
	List<Map<String, String>> data= dataTable.asMaps(String.class,String.class);
	System.out.println(data);
	for(int i=0;i<data.size();i++) {
		 FirstName=data.get(i).get("FirstName");
		 LastName=data.get(i).get("LastName");
		 Postcode=data.get(i).get("Postcode");
		 
		 checkout.fillYourInformation(FirstName, LastName, Postcode);
		 
	}
	
		
}
@Then("User Cancel the Checkout Process")
public void cancel_checkout() {
	checkout.cancel();
		
}

@Then("User Finish the Checkout Process")
public void finish_checkout() {
	boolean resultFin=checkout.finish();
	 Assert.assertEquals(resultFin, true,"User Successfully Orderd the Product");	
}
}
