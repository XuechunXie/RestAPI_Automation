import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourse() {
		JsonPath json = new JsonPath(payload.coursePrice());
		
		int count = json.getInt("courses.size()");
		int sum = 0;
		for(int i = 0; i < count; i++) {
			int price = json.getInt("courses["+i+"].price");
			int copies = json.getInt("courses["+i+"].copies");
			sum += price*copies;
		}
		int purchaseAmt = json.getInt("dashboard.purchaseAmount");
		//System.out.println(sum);
		Assert.assertEquals(sum, purchaseAmt);
	}
}
