package RestAssuredBasics;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetRequest5 {
//	firstName: Mary
//	Smith
	@Test
	public void restAssuredGet() {
		// RestAssured.baseURI="https://restful-booker.herokuapp.com";

		JsonPath jsonpath = 
				
				RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
			.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("firstname",Matchers.equalTo("James1"))
			.body("bookingdates.checkin",Matchers.equalTo("2018-01-01"))
			.extract()//Extract the value from JSONPath
			.jsonPath();
	
			System.out.println(jsonpath.getString("firstname"));
			System.out.println(jsonpath.getString("bookingdates.checkout"));
			
	
		
		
		

	}
}
