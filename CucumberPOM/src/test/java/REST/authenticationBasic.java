package REST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class authenticationBasic {
	@Test
	public void basicAut() {
		given().
		auth().basic("postman", "password").
		when().get("https://postman-echo.com/basic-auth").
		then().
		statusCode(200).
		body("authenticated", equalTo(true)).
		log().all();
	}
	
	@Test
	public void digestAuth() {
		given().
		auth().digest("postman", "password").
		when().get("https://postman-echo.com/basic-auth").
		then().
		statusCode(200).
		body("authenticated", equalTo(true)).
		log().all();
	}
	
	@Test
	public void preemptiveAuth() {
		given().
		auth().preemptive().basic("postman", "password").
		when().get("https://postman-echo.com/basic-auth").
		then().
		statusCode(200).
		body("authenticated", equalTo(true)).
		log().all();
	}

}
