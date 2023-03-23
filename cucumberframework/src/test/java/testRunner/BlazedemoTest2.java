package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\HP\\eclipse\\cucumberframework\\src\\main\\java\\featureFile"},
		glue = {"commanStepDefination","blazedemoTestPom"},
		dryRun=false,
		monochrome = true, 
		plugin = {"pretty","html:Reports//cucumber-reports.html"},
		tags= "@regressiontest" 
		
		)

public class BlazedemoTest2 extends AbstractTestNGCucumberTests {

}
