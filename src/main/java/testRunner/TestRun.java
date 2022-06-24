package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/main/java/com/features",
	glue="stepDefination",
	dryRun=false,
	monochrome=true,
	plugin= {"html:target"}
		
		)

public class TestRun {

	
}
