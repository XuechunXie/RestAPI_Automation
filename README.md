This Project is a RestAPI Automation project with cucumber framework. Intruction of the 4 folders:

RestDemo -- Only use RestAssured to implemeted the POST/PUT/GET/DELETE

Automation -- Introduction of automation with Cucumber
 1.Gherkin Synctax(Case Sensitive) includes:  Given -- the preconditions
                             	              When -- the user action
                                              Then -- the expected output
                                              And/But -- concatenate word, can be used in Given/When/Then
 2. Feature File end with .feature, show as below:
    Feature: The Buisiness Requirement
    Scenario: test cases1
    Scenario: test case2


Required Jars -- Jar files required for RestDemo, need to import mannually to eclipse

APIFramework -- RestAPI Automation use cucumber, RestAssure and POJO