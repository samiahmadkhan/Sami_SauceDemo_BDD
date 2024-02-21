package REST;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.JSONObject;
import org.json.JSONString;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class SeriesTestCase_GET {
	
	@Test
	public void getUser(ITestContext context) { 
	    
		
		String token="9794f502b43dbd0cd1254f29278b6f3dccce2672e4c15d286207877590aefb6c";
		int id=(int) context.getAttribute("user_id");
		
	    Response res=given().
	    		pathParam("id",id).
		headers("Authorization","Bearer "+ token).
		contentType("application/json").
		when().get("https://gorest.co.in/public/v2/users/{id}");
	    
	    AssertJUnit.assertEquals(res.getStatusCode(),200);
	    System.out.println( "GET Result of Response Body is ____________________________");
	    System.out.println(res.getBody().asString());
	    System.out.println("________________________________");
	    
	   
	    
	}

}
