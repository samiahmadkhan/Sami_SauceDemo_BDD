package REST;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class readXMLParse {
	Response res;
	@BeforeMethod
	public void init() {
	    res=given().
		when().get("http://restapi.adequateshop.com/api/Traveler");
	}

	@Test
	public void simpleXmlRead() {
		String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		System.out.println("Name is equal = "+ name);
		Assert.assertEquals(name, "Developer");

	}
	
	@Test
	public void XMLParseBody() {
		XmlPath xo=new XmlPath(res.asString());
		List<String> data=xo.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean flag=false;
		for(String a:data) {
			System.out.println("Name = " + a);
			if(a.equalsIgnoreCase("Karen"))
				flag=true;
		}
		if(flag==true)
			System.out.println("Found the Name Karen");
		else System.out.println("Not found the name Karen");
	}
}
