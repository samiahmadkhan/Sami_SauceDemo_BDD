package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.factory.driverFactory;
import com.pages.yourCartPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class yourCartStepDef {
	
	private yourCartPage cartPage=new yourCartPage(driverFactory.getDriver());
	
	@Then("User lands on Your Cart Page")
	public void User_lands_Your_Cart_Page() {
		boolean result=cartPage.verifyYourCartPage();
		Assert.assertEquals(result, true,"User Successfully landed on Your Cart Page");	
	}
	
	@Then("User Verify Products are visible on Your Cart Page")
	public void User_products_Your_Cart_Page(DataTable dataTable) {
		String productName;
		boolean result;
		List<Map<String, String>> data= dataTable.asMaps(String.class,String.class);
		for(int i=0;i<data.size();i++) {
			 productName=data.get(i).get("Products");
			 result=cartPage.isProductVisible(productName);
			 Assert.assertEquals(result, true,"Product : "+ productName + " is present on Your Carts Page");	
		}
		
			
	}
	
	@Then("User Removes Products {string}")
	public void User_RemovesProducts_Your_Cart_Page(String productName) {
		cartPage.RemoveProduct_YourCart(productName);
		
	}

}
