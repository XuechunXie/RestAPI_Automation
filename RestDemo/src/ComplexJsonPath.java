import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {
	
	public static void main(String[] args) {
		JsonPath json = new JsonPath(payload.coursePrice());
		
		//Refer to https://jsoneditoronline.org/#left=local.regive&right=local.cudili
		
		//1. Print No of courses returned by API
		int noOfCourse = json.getInt("courses.size()");
		System.out.println("noOfCourse:"+noOfCourse);

		//2.Print Purchase Amount
		int purchaseAmt = json.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount:"+purchaseAmt);
		
		//3. Print Title of the first course
		String title = json.getString("courses[0].title");
		System.out.println("title:"+title);
		
		//4. Print All course titles and their respective Prices
		String course = json.getString("courses");
		System.out.println("course:"+course);
		for(int i = 0; i < noOfCourse; i++) {
			String titlei = json.getString("courses["+i+"].title");
			int price = json.getInt("courses["+i+"].price");
			System.out.println("course"+i+":"+titlei+","+price);
		}
		
		
		//5. Print no of copies sold by RPA Course
		for(int i = 0; i < noOfCourse; i++) {
			String titlei = json.getString("courses["+i+"].title");
			int copies = 0;
			if(titlei.contentEquals("RPA")) {
				copies = json.getInt("courses["+i+"].copies");
				System.out.println("copies"+i+":"+titlei+","+copies);
				break;
			}
			
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
	}
}
