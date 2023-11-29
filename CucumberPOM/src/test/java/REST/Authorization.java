package REST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authorization {
	
	@Test
	public void bearer() {
		given().
		headers("Authorization","Bearer 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").
		when().get("https://api.github.com/user/repos").
		then().statusCode(200).
		log().all();
		
	}
	
	@Test
	public void oath1() {
		given().auth().oauth("RKCGzna7bv9YD57c", "D+EdQ-gs$-%@2Nu7","","").
		when().get("https://postman-echo.com/oauth1").
		then().statusCode(200);
	}

	
}
