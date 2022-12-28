package PayLoadHandling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class NestedJSONPayLoad {
/*
 * While creating the JSON payload for the nested object and arrays 
 * Always start from the inside and then go to outside
 * We should follow: INSIDE OUT RULE
 */
	@Test(priority = 0)
	public void createNestedPayload() {

		//Skills
		Map<String, Object> skill1 = new LinkedHashMap<String, Object>();
		skill1.put("sub", "Java");
		skill1.put("exp", 5);
		skill1.put("proficiency", "Intermediate");
		
		Map<String,Object> skill2=new LinkedHashMap<String,Object>();
		skill2.put("sub", "selenium");
		skill2.put("proficiency", "Automation Expert");
		
		List<Map<String,Object>> skills=new ArrayList<>();
		skills.add(skill1);
		skills.add(skill2);
		System.out.println(skills);
		
		List<String> mobiles = new ArrayList<String>(); //For storing mobile nos
		mobiles.add("9823733274");
		mobiles.add("934834943");
		mobiles.add("93463463462");
		System.out.println(mobiles);
		
		//Booking Dates
		Map<String,Object> bookingDates=new LinkedHashMap<>();
		bookingDates.put("checkin", "2022-12-09");
		bookingDates.put("checkout", "2022-12-20");
		
		//All details:
		Map<String,Object> details =new LinkedHashMap<String,Object>();
		details.put("firstname", "steve");
		details.put("lastname", "jobs");
		details.put("address", "Baliyari");
		details.put("age", 28);
		details.put("isMarried", false);
		details.put("gender","M");
		
		details.put("bookingDates", bookingDates);
		details.put("mobiles", mobiles);
		details.put("skills", skills);
		
		System.out.println(details);
		

	}
}
