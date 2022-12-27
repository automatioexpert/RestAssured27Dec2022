package RestAssuredBasics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest3 {
//	firstName: Mary
//	Smith
	@Test
	public void restAssuredGet() {
		//RestAssured.baseURI="https://restful-booker.herokuapp.com";
	
	Response response=	RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
	String firstName=response.jsonPath().get("firstname").toString(); 
	System.out.println("firstName: "+firstName);
	
	String lastname=response.jsonPath().getString("lastname");
	System.out.println(lastname);
	
	//If we know the type of the value then use methods like getInt(),getInt() etc
	//But if do not know the type 
	//we user get()
	//{checkin=2022-11-18, checkout=2022-12-26}
	Object obj=response.jsonPath().get("bookingdates"); //Object type - Use if dnt know the type of the object
	System.out.println(obj);
	
	//Checkin
	Object checkin=response.jsonPath().get("bookingdates.checkin"); //Object type - Use if dnt know the type of the object
	System.out.println(checkin);
	System.out.println(checkin instanceof String);
	System.out.println(checkin instanceof Boolean);
	System.out.println(checkin instanceof Integer);
	System.out.println(checkin instanceof Object);
	
	}

}

/*
Open Declaration   JsonPath io.restassured.response.ResponseBodyExtractionOptions.jsonPath()


Get a JsonPath view of the response body. This will let you use the JsonPath syntax to get values from the response.Example: 

Assume that the GET request (to http://localhost:8080/lotto) returns JSON as: 
{
"lotto":{
 "lottoId":5,
 "winning-numbers":[2,45,34,23,7,5,3],
 "winners":[{
   "winnerId":23,
   "numbers":[2,45,34,23,3,5]
 },{
   "winnerId":54,
   "numbers":[52,3,12,11,18,22]
 }]
}
}


You can the make the request and get the winner id's by using JsonPath:  List winnerIds = get("/lotto").jsonPath().getList("lotto.winners.winnerId");
*/
