
package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\HP\\git\\cucumberrepository\\cucumberframework\\src\\main\\java\\featureFile"},
		glue = {"commanStepDefination","blazedemoTestPom"},
		dryRun=false,
		monochrome = true, 
		plugin = {"pretty","html:Reports//cucumber-reports.html","json:target/cucumber-reports.json"},
		//tags= "@regressiontest"
		tags="@smoketest"
		
		)

public class BlazedemoTest2 extends AbstractTestNGCucumberTests {

}
