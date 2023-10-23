
package REST;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET {
	
	@Test
	public void testVerifyListSize() {
		
		given().
		when().get("https://reqres.in/api/users?page=2").
		then().
		     assertThat().
		     statusCode(200).
		     and().
		     body("data.id.", hasSize(6));
	}
	@Test
	public void testVerifyData() {
		
		given().
		when().get("https://reqres.in/api/users?page=2").
		then().
		     assertThat().
		     statusCode(200).
		     and().
		     body("data[5].first_name.", equalTo("Rachel")).
		     body("data[0].first_name.",equalTo("Michael")).
		     body("data[4].id.",equalTo(11)) ;
		    
	}
	@Test
	public void Get_Single() {
		
		given().
		when().get("https://reqres.in/api/users/2").
		then().
		     assertThat().
		     statusCode(200).
		     and().
		     body("data.first_name.", equalTo("Janet")).
		     body("data.last_name.",equalTo("Weaver")).
		     body("data.id.",equalTo(2)) ;
		    
	}

}
