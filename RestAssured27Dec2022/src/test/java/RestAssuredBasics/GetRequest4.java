package RestAssuredBasics;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest4 {
//	firstName: Mary
//	Smith
	@Test
	public void restAssuredGet() {
		// RestAssured.baseURI="https://restful-booker.herokuapp.com";

		String firstname = 
				
				RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
			.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("firstname",Matchers.equalTo("Mark"))
			.body("bookingdates.checkin",Matchers.equalTo("2022-12-06"))
			.extract()//Extract the value from JSONPath
			.jsonPath()
			.getString("firstname");
	
		System.out.println(firstname);
		
		
		

	}
}

/*
 * Open Declaration JsonPath
 * io.restassured.response.ResponseBodyExtractionOptions.jsonPath()
 * 
 * 
 * Get a JsonPath view of the response body. This will let you use the JsonPath
 * syntax to get values from the response.Example:
 * 
 * Assume that the GET request (to http://localhost:8080/lotto) returns JSON as:
 * { "lotto":{ "lottoId":5, "winning-numbers":[2,45,34,23,7,5,3], "winners":[{
 * "winnerId":23, "numbers":[2,45,34,23,3,5] },{ "winnerId":54,
 * "numbers":[52,3,12,11,18,22] }] } }
 * 
 * 
 * You can the make the request and get the winner id's by using JsonPath: List
 * winnerIds = get("/lotto").jsonPath().getList("lotto.winners.winnerId");
 */
