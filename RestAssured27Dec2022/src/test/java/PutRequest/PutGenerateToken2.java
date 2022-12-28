package PutRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PutGenerateToken2 {
	
	static String token="";
//Use of static keyword is always avoided to support parallel thread execution
//static keyword should NOT be used 
//If the execution has to be done parallely
	
	@Test(priority = 0)
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
		
	}
	
	@Test(priority = 1)
	public void updateBooking() {
	
	Response response=	RestAssured
		.given()
			.log()
			.all()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Cookie","token="+token)
			.baseUri("https://restful-booker.herokuapp.com")
			.body("{\r\n"
					+ "    \"firstname\" : \"James38\",\r\n"
					+ "    \"lastname\" : \"Brown373\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
			.when()
				.put("booking/1")
			.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.response();
		
	response.prettyPrint();

/*
	[RemoteTestNG] detected TestNG version 7.4.0
	Request method:	POST
	Request URI:	https://restful-booker.herokuapp.com/auth
	Proxy:			<none>
	Request params:	<none>
	Query params:	<none>
	Form params:	<none>
	Path params:	<none>
	Headers:		Accept=*//*//
				
	/*Content-Type=application/json
	Cookies:		<none>
	Multiparts:		<none>
	Body:
	{
	    "username": "admin",
	    "password": "password123"
	}
	HTTP/1.1 200 OK
	Server: Cowboy
	Connection: keep-alive
	X-Powered-By: Express
	Content-Type: application/json; charset=utf-8
	Content-Length: 27
	Etag: W/"1b-2HrUSexEqRmiulqES4KJiGeBLI0"
	Date: Wed, 28 Dec 2022 05:02:17 GMT
	Via: 1.1 vegur

	{
	    "token": "c3295ad62d84760"
	}
	Token generated is : c3295ad62d84760
	PASSED: updateBooking

	===============================================
	    Default test
	    Tests run: 1, Failures: 0, Skips: 0
	===============================================


	===============================================
	Default suite
	Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
	===============================================

	*/

	}

}
