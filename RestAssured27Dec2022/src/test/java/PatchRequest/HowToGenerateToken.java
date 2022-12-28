package PatchRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class HowToGenerateToken {
/*In order to generate the Token
 * use the complete URI with endpoint 
 * Go to postman:
 *Select POST option
 *and body as application/json as below:
 *{
    "username" : "admin",
    "password" : "password123"
}
 *Each time a new token is generated when we send a 
 *Post request
 * 
 * @Test(priority = 0)
	public void generateToken() {

		 token=RestAssured
		.given()
			.log()
			.all()
			.contentType(ContentType.JSON)
			.baseUri("https://restful-booker.herokuapp.com")
			.body("{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
					+ "}")
			.when()
				.post("/auth")
			.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.jsonPath()
				.getString("token");
				
//    "token": "8743c5ef188a159"
		
	}
	
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

}
