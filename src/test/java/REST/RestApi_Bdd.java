package REST;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.mongodb.operation.CreateUserOperation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class RestApi_Bdd {
	int id;
	@Test
	public void getListUser() {
		
		//https://reqres.in/api/users?page=2
		given().
		pathParam("path", "users").queryParam("page",2).
		when().get("https://reqres.in/api/{path}").
		then().
		assertThat().
		statusCode(200).
		body("data.id[0]", equalTo(7)).
		
		log().all();

	}
	
	//@Test
	public void createUserPost() {
		
		JSONObject data=new JSONObject();
		data.put("name", "morpheus");
		data.put("job", "leader");
		System.out.println(data);
		
		 id=given().body(data).
		when().post("https://reqres.in/api/users").jsonPath().getInt("id");
		System.out.println("id is equal = "+ id);
//		then().
//		statusCode(201).
//		log().all();
	}
	
	//@Test(dependsOnMethods = "createUserPost")
	public void updateDataPUT() {
		JSONObject data=new JSONObject();
		data.put("name", "morpheus");
		data.put("job", "zion resident");
		System.out.println(data);
		
		given().contentType("application/json").body(data).
		when().put("https://reqres.in/api/users/"+id).
		then().statusCode(200).log().all();
		
	}
}
