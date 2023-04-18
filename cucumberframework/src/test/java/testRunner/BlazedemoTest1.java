package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\HP\\git\\cucumberrepository\\cucumberframework\\src\\main\\java\\featureFile"},
		glue = {"commanStepDefination","blazedemoTestPom"},
		dryRun=false,
		monochrome = true,
		publish = true,
		plugin = {"pretty","html:Reports//cucumber-reports.html","json:Reports/cucumber-reports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:Reports/FailedReport/failedRerun.txt"},
		
		//tags= "@smoketest or @regressiontest" //we have to run all scanarios
		tags= "@smoketest or @regressiontest" //we have to skip scanarios
		//tags= " not @smoketest or @regressiontest" 
		
		)

public class BlazedemoTest1 extends AbstractTestNGCucumberTests {
		
}

