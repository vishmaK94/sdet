package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "Features",
		glue= {"stepDefinitions"},
		tags= "@tag2"
		
		)
public class HRMRunner {

}
