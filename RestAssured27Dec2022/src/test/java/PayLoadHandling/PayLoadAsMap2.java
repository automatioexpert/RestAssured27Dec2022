package PayLoadHandling;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayLoadAsMap2 {
	Map<String, Object> jsonObject;

	@Test(priority = 0)
	public void mapLoad() {
		jsonObject = new LinkedHashMap<>();
		jsonObject.put("name", "Steve");
		jsonObject.put("salary", 10000000);
		System.out.println(jsonObject);
		
		Map<String,Object> address2=new LinkedHashMap<String,Object>();
		address2.put("street", "Wall street Layout");
		address2.put("city", "BLR");
		address2.put("state", "KA");
		
		//WorkVisa
		Map<String,Object> visa=new HashMap<String,Object>();
		visa.put("US", false);
		visa.put("UK", true);
		
		//Put visa inside address object
		address2.put("visa", visa);
		
		jsonObject.put("address", address2);
		System.out.println(jsonObject);
 	}
	
	//@Test(priority = 1)
	public void sendPayload()
	{
		RestAssured.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.baseUri("https://restful-booker.herokuapp.com/booking")
		.body(jsonObject)
		.when()
		.post("")
		.then()
		.log()
		.all();
	//java.lang.IllegalStateException: Cannot serialize object because no JSON serializer found in classpath. Please put Jackson (Databind), Gson, Johnzon, or Yasson in the classpath.

		
	}
}
