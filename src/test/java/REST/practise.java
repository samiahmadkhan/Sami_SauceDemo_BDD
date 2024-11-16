package REST;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.common.collect.Multiset.Entry;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class practise {
private static final String Map = null;

public void getBooksDetails() {
	RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
	RequestSpecification httpRequest=RestAssured.given();
	Response response =httpRequest.get("");
	System.out.println("Response Body =" + response.asPrettyString());
	System.out.println("status code = " + response.getStatusCode());
	System.out.println("status code line= " + response.getStatusLine());
	Assert.assertEquals(200, response.getStatusCode());
	
	Headers header=response.headers();
	
	for(Header headr:header) {
	
	}
	
	System.out.println("Testing heaers "+header);
	 ResponseBody bd=response.body();
	 System.out.println("2nd responsebdy = "+ bd.asPrettyString());
	 
	 JsonPath jsonpath=response.jsonPath();
	
	 JSONObject obj=new JSONObject(bd.asString());
	 JSONArray ja=(JSONArray)obj.get("books");
	 Iterator i2=ja.iterator();
	 while(i2.hasNext()) {
		 //System.out.println("Array index " + i2.next());
		  Iterator i1=((Map)i2.next()).entrySet().iterator();
		  while(i1.hasNext()) {
			  Map.Entry pair=(java.util.Map.Entry) i1.next();
			  System.out.println(pair.getKey() + " : " + pair.getValue()); 
			  
		  }
		 
	 }
	 
	 //System.out.println("title of json = "+jsonpath.get("title"));
	
	
}
//@Test
public void post() {
	RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httpReq=RestAssured.given();
		
		JSONObject obj=new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "leader");
		httpReq.header("Content-Type","application/json");
		System.out.println(obj.toString());
		httpReq.body(obj.toString());
		Response response=httpReq.post("/api/users");
		System.out.println("The status received: " + response.statusLine());
		System.out.println("Respone =  " + response.body().asPrettyString());
		
		
	
}
//@Test
public void getNewDataAded() {
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification httpreq=RestAssured.given();
	Response res=httpreq.get("api/users");
	System.out.println("Respone =  " + res.body().asPrettyString());
}

}
