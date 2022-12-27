package RestAssuredBasics;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {
//Below exception is raised when hit the API
//request when there is No internet connection
//java.net.UnknownHostException: No such host is known 
//(restful-booker.herokuapp.com)
	@Test
	public void restAssuredGet() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
	
		Response response=
		given()
		.when().get("/booking/1");
		//.then().assertThat().statusCode(200);
		
		//response.prettyPrint();
		//Convert response as a String
	
	String reponseString=	response.asString();
	System.out.println(reponseString);
//{"firstname":"Sally","lastname":"Brown","totalprice":570,"depositpaid":false,"bookingdates":{"checkin":"2019-02-15","checkout":"2020-12-01"}}
	System.out.println(response.getStatusCode());
	System.out.println(response.statusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.statusLine());
	Assert.assertEquals(response.getStatusCode(),200);
	Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
/*
	200
	200
	HTTP/1.1 200 OK
	HTTP/1.1 200 OK */
	
	}

}
