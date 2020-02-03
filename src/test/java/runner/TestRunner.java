package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/features/employee.feature"},
		glue= {"stepdefinitions"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:target/reports"}
		
	)
public class TestRunner {

}
