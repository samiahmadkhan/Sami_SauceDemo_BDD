package stepDefinations;

import com.FactoryNew.DriverManager;
import org.testng.Assert;

import com.factory.driverFactory;
import com.pages.ProductsPage;
import com.pages.yourCartPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPageStepDef {
	//private ProductsPage productspage=new ProductsPage(driverFactory.getDriver());
	private ProductsPage productspage=new ProductsPage(DriverManager.getDriver());


	private yourCartPage yourCart;

	@Then("User should land on Products Page")
	public void user_land_on_products_page() {
		String pagetitle=productspage.getProductsPageName();
		Assert.assertEquals(pagetitle, "Products", "Test Paased: User Successfully Landed on Products Page");
		

	}
	
	@Then("{string} and its respective {string} should be displayed")
	public void product_name_and_its_image(String productname,String imagename) {
		boolean productVisible=productspage.isProductVisible(productname);
		Assert.assertEquals(productVisible, true,"Product Is Visible");
		boolean imageExists=productspage.verifyProductImage(imagename);
		
		Assert.assertEquals(imageExists, true,"Correct Image: "+ imagename+ " is visible for Product: "+  productname);
	}
	
	@When("User adds {string} to cart")
	public void user_add_product_to_cart(String productname) {
		productspage.addProducttoCart(productname);
		
		
	}
	@Then("Verify Product is added in Shopping Bag")
	public void verify_shopping_bag() {
		boolean result=productspage.verifyProductisAdded();
		Assert.assertEquals(result, true,"Product is Added Successfully");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Then("Verify Product is Removed from Shopping Bag {string}")
	public void verify_product_removed_from_shopping_bag(String productname) {
		boolean result=productspage.verifyProductisRemoved(productname);
		Assert.assertEquals(result, true,"Product is Removed Successfully , because Add to Cart is Visible Again");		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("User should be able to remove {string} from Products")
	public void user_remove_product_from_productpage(String productname) {
		productspage.RemoveProductfromCart(productname);
	}
	@Then("User Logout from Products Page")
	public void logout_from_product_page() {
		productspage.logoutFromProductPage();
		
	}
	@When("User navigated to Your Cart page")
	public void user_navigate_yourCart_Page() {
		yourCart=productspage.naviagteYourCartPage();
		
	}
	
	@Then("User Reset App State")
	public void reset_App_state() {
		productspage.resetAppState();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
