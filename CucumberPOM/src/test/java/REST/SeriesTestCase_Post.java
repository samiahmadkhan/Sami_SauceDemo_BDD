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
public class SeriesTestCase_Post {
	
	@Test
	public void createUser(ITestContext context) { 
	    //TestNg ITestContext which will behave like global variable to store all instance of this test
		
		//faker to generate random data 
		//need to add maven dependency of faker
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("email", faker.internet().emailAddress());
		data.put("name", faker.name().fullName());
		data.put("gender","Male");
		data.put("status", "inactive");
		
		String token="9794f502b43dbd0cd1254f29278b6f3dccce2672e4c15d286207877590aefb6c";
		
	    Response res=given().
		headers("Authorization","Bearer "+ token).
		contentType("application/json").
		body(data.toString()).
		when().post("https://gorest.co.in/public/v2/users");
	    
	    AssertJUnit.assertEquals(res.getStatusCode(),201);
	   // System.out.println(res.asString());
	    System.out.println(res.getBody().asString());
	    
	    
//here this id has to be used wth other classes also where will will get, delete and update the user with same id
	    //so for that we will use TestNg ITestContext which will behave like global variable
	    int id=res.jsonPath().getInt("id");
	    System.out.println("id = "+ id);
	    
	    context.setAttribute("user_id", id);
	}

}
