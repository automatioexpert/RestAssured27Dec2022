package PostRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {
	
	@Test
	public void createBooking() {
	
	Response response=RestAssured.
	given()
	.contentType(ContentType.JSON)
	.body("{\r\n"
			+ "    \"firstname\" : \"Jim\",\r\n"
			+ "    \"lastname\" : \"Brown\",\r\n"
			+ "    \"totalprice\" : 111,\r\n"
			+ "    \"depositpaid\" : true,\r\n"
			+ "    \"bookingdates\" : {\r\n"
			+ "        \"checkin\" : \"2018-01-01\",\r\n"
			+ "        \"checkout\" : \"2019-01-01\"\r\n"
			+ "    },\r\n"
			+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
			+ "}")
	
	.post("https://restful-booker.herokuapp.com/booking");
	response.prettyPrint();
	System.out.println("========================");
	System.out.println(response.getStatusCode());
	
//	Internal Server Error
//	========================
//	500
	}

}
