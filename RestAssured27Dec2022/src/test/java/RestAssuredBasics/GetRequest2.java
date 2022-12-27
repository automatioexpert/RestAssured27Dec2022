package RestAssuredBasics;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest2 {

	@Test
	public void restAssuredGet() {
		//RestAssured.baseURI="https://restful-booker.herokuapp.com";
	
		RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
		.statusCode(200)
		.log().all()
		.statusLine("HTTP/1.1 200 OK")
		.body("firstname",Matchers.equalTo("Eric"))
		.body("bookingdates.checkin", Matchers.equalTo("2016-02-25"))
		.body("lastname",Matchers.equalTo("Ericsson"))
		.body("totalprice",Matchers.equalTo(636))
		.body("depositpaid",Matchers.equalTo(false));
		
		
	
	}

}
