package PayLoadHandling;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayLoadAsMap {
	Map<String, Object> jsonObject;

	@Test(priority = 0)
	public void mapLoad() {
		jsonObject = new HashMap<>();
		jsonObject.put("name", "Steve");
		jsonObject.put("salary", 10000000);
		System.out.println(jsonObject);
	}
	
	@Test(priority = 1)
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
