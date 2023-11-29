package REST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class readJsonBody {
Response res;
	@BeforeMethod
	public void init() {
		 res=given().
				 headers("Content-Type","Application/json").
				 contentType(ContentType.JSON).
		         when().get("https://demoqa.com/BookStore/v1/Books");
		 
	}
	
	@Test
	public void verifySimpleRes() {
		String ActualId=res.jsonPath().get("books[1].title").toString();
		Assert.assertEquals(ActualId,"Learning JavaScript Design Patterns"); //but here its hardcoded
	}
	@Test
	public void usingJSONObj() {
		JSONObject jo=new JSONObject(res.asString()); //its imp to convert res to string using asString
		for(int i=0;i<jo.getJSONArray("books").length(); i++) {
			String title=jo.getJSONArray("books").getJSONObject(i).get("title").toString();
			System.out.println("title = " + title);
		}
	}
	
}
