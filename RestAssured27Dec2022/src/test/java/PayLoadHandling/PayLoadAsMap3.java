package PayLoadHandling;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class PayLoadAsMap3 {

	@Test(priority = 0)
	public void mapLoad() {
		//Address1
		Map<String,Object> address1=new LinkedHashMap<>();
		address1.put("street", "wall street");
		address1.put("city", "blr");
		address1.put("state", "NY");
		System.out.println(address1);
		
		//Address2
		Map<String,Object> address2=new LinkedHashMap<>();
		address2.put("street", "new wall street");
		address2.put("city", "ns");
		address2.put("state", "DY");
		System.out.println(address2);
		
		List<Map<String,Object>> allEmps= new ArrayList<>();
		allEmps.add(address1);
		allEmps.add(address2);
		System.out.println(allEmps);
		
		//O/P:
		//[{street=wall street, city=blr, state=NY}, 
		//{street=wall street, city=blr, state=NY}]		
				
	}
}
