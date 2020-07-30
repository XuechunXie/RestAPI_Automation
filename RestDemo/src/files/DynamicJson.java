package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String postResp = given().log().all().header("Content-Type","application/json").body(payload.addBook(isbn,aisle)).
		when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath json = ReusableMethods.rawToJson(postResp);
		String id = json.getString("ID");
		System.out.println(id);
		
		
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData(){
		return new Object[][] {{"23add","333"},{"sdfd","222"},{"dddd","444"}};
	}
}
