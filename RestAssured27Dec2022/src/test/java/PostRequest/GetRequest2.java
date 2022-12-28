package PostRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest2 {
	
	@Test
	public void createBooking() {
	
	RestAssured.
	given()
	.when()
	.get("https://restful-booker.herokuapp.com/booking/10")
	.then()
	.statusCode(200);
		

	}

}
