import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import pojo.GoogleMaps;
import pojo.Location;

public class specBuilderTest {

	public static void main(String[] args) {
	    // Write code here that turns the phrase above into concrete actions
			//Set up the body with POJO
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Set up the body with POJO
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		GoogleMaps map = new GoogleMaps();
		map.setAccuracy(50);
		map.setAddress("29, side layout, cohen 09");
		map.setLanguage("French-IN");
		map.setLocation(location);
		map.setName("Frontline house for serialization");
		map.setPhone_number("(+91) 983 893 3937");
		map.setTypes(types);
		map.setWebsite("http://google.com");
		
		
		//Request Spec Builder
		
		RequestSpecification requestSpe = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		ResponseSpecification responsSpe = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res = given().spec(requestSpe)
		.body(map);
		
		//Only with request specificaton
		String response1 =res.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath json = new JsonPath(response1);
		System.out.println(response1);
		String placeId = json.getString("place_id");
		

		//with both response and request specification
		String response2 = res.when().post("/maps/api/place/add/json")
				.then().spec(responsSpe).extract().response().asString();
		System.out.println(response2);
		
	
	}
	

}
