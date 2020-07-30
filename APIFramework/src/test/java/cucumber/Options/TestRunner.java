package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src/test/java/features",    //it will run all the feature files under this folder, if we just want to run one, specify it
		plugin  ="json:target/jsonReports/cucumber-report.json", //report path, run with command 'mvn test verify'
		glue = {"stepDefinition"}
		//tags = "@DeletePlace"                 //if we don't have this then it will run all the test cases
		)
public class TestRunner {

}
