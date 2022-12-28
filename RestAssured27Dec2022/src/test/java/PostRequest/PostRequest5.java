package PostRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostRequest5 {
	
	@Test
	public void createBooking() {
	
	Response response=
		RestAssured.get("https://restful-booker.herokuapp.com/10")
			.then()
				.extract()
					.response();
		
//	response.prettyPrint();
	
	//$ - In JSONPathFinder.com,we had x.id etc
	//But in Rest Assured it is $ sign
	int size=response.jsonPath().getList("$").size();
	System.out.println("Size is : "+size);
	

	}

}
