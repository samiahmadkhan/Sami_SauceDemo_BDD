package REST;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class cookies {

//@Test
	public void Cookies() {
		given().
		when().get("https://www.google.com/").
		then().cookie("AdEC"); //this will fail as this cookie does not exists
		
	}
	
	@Test
	public void getSingleCookie() {
		Response res=given().when().get("https://www.google.com/");
		String cookieValueAEC=res.getCookie("AEC");
		
		System.out.println("Value of cookie AEC = "+ cookieValueAEC);
	}
	
	//@Test
	public void getAllCookie() {
		Response res=given().when().get("https://www.google.com/");
		Map<String,String> mp=res.getCookies();
		
		for(String data: mp.keySet()) {
			
			String val=res.getCookie(data);
			System.out.println("Key name = "+data+" ; value = "+val);
		}
	}
	@Test
	public void getAllCookie2() {
		Response res=given().when().get("https://www.google.com/");
		Map<String,String> mp=res.getCookies();
		
		for(Map.Entry<String,String> data : mp.entrySet()) {
			System.out.println("Key is = " +data.getKey() + "; Value = "+data.getValue());
		}
	}
}
