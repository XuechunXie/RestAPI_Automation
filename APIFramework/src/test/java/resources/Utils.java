package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	//static make sure all the running only one instance is using, that means the requestSpe will be not null next time
	//and which will make the code only run once in the if(requestSpe == null) branch
	public static RequestSpecification requestSpe;
	public RequestSpecification requestSpecification() throws IOException {
		//if there is no if statement, the logging.txt will be clear first everytime and write with the new log
		if(requestSpe == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			String baseUrl = getGlobalValue("baseUrl");
			requestSpe = new RequestSpecBuilder().setBaseUri(baseUrl).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();			
		}
		return requestSpe;

	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		String root = System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream(root+"\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key) {
		JsonPath json = new JsonPath(response.asString());
		return json.getString(key);
	}

}
