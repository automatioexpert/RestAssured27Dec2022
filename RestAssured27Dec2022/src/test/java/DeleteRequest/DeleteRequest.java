package DeleteRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequest {
	
	@Test(priority = 0)
	public void deleteRequest() {
		
		RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
		
		
		
		
	}
}
