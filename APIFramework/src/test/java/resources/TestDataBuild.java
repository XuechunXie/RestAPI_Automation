package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.GoogleMaps;
import pojo.Location;

public class TestDataBuild {

	
	public GoogleMaps addPlacePayload(String name, String language, String address) {
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		
		GoogleMaps map = new GoogleMaps();
		map.setAccuracy(50);
		map.setAddress(address);
		map.setLanguage(language);
		map.setLocation(location);
		map.setName(name);
		map.setPhone_number("(+91) 983 893 3937");
		map.setTypes(types);
		map.setWebsite("http://google.com");
		return map;
	}
	
	public String deletePlacePayload(String place_id) {
		return "{\r\n   \"place_id\":\""+place_id+"\"\r\n}";
	}
}
