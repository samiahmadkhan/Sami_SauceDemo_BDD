package REST;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class header {

	//@Test
	public void headerVerify() {
		given().
		queryParam("page", 2).
		when().get("https://reqres.in/api/users").
		then().
		header("Cache-Control","max-age=14400").
		header("Content-Type","application/json; charset=utf-8").
		log().headers();
	}
	
	//@Test
	public void getSingleHeader() {
		Response res=given().
		queryParam("page", 2).
		when().get("https://reqres.in/api/users");
		
		String headerContentTyp=res.getHeader("Content-Type");
		System.out.println("Header value is = "+ headerContentTyp);
	}
	
	@Test
	public void getAllHeader() {
		Response res=given().
				queryParam("page", 2).
				when().get("https://reqres.in/api/users");
		
		Headers allHead=res.getHeaders();
		
		for(Header hd:allHead) {
			System.out.println("Header = "+hd.getName()+" ; value = "+hd.getValue() );
		}
	}
}
