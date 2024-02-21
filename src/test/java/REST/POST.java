package REST;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.json.JSONString;
import org.testng.annotations.Test;

public class POST {
	@Test
	public void addUser() {
		JSONObject request=new JSONObject();
		request.put("name","morpheus");
		request.put("job","leader");
		
		System.out.println(request.toString());
		
		given().
		body(request.toString()).log().all().
		when().post("https://reqres.in/api/users").
		then().
		     statusCode(201).log().all();
		     
		    
	}
}
