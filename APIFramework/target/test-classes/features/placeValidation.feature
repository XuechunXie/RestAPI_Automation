Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
	
Examples:
	|name|language|address|
	|mike|English|milpitas|
#	|michelle|Chinese|far from me|


@DeletePlace
Scenario: Verify if Delete Place functionality is working
	Given DeletePlace payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"	