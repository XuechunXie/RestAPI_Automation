import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReusableMethods;
import files.payload;
public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//this package is static, so we should imported it manually
		//Add place -> Update Place with New Address -> Get Place to validate if new address is present in response
		
		//POST
		// Step1 : Add place in google maps-->POST, store the response json into response
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(Addplace()).
		when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		
		 //Step2: parse the Json(response) to get place_id
		JsonPath json = new JsonPath(response);
		String placeid = json.getString("place_id");
		System.out.println(placeid);
		
		//PUT
		//Step3: Update the address with place_id
		String newAdd = "Summer in New York long island";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\""+newAdd+ "\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GET
		//step4: Get the new address and validate it
		//Since we don't send any body, so we don't need header
		String responseGet = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
				.when().get("maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//JsonPath jsonGet =new JsonPath(responseGet);
		String address = ReusableMethods.rawToJson(responseGet).get("address");
		
		//Java doesn't have it's own assertion method, two popular test framework: Cucumber Junit and TestNg
		Assert.assertEquals(address, "not the right one");
		
	}
	
	public static String Addplace() {
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"michelle\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}

}
