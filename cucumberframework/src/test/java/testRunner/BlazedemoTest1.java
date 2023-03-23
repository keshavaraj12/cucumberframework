package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\HP\\eclipse\\cucumberframework\\src\\main\\java\\featureFile"},
		glue = {"commanStepDefination","blazedemoTestPom"},
		dryRun=false,
		monochrome = true,
		publish = true,
		plugin = {"pretty","html:Reports//cucumber-reports1.html","json:target/cucumber-reports/cucumber.json"},
		
		//plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		//tags= "@smoketest or @regressiontest" //we have to run all scanarios
		tags= "@smoketest and not @regressiontest" //we have to skip scanarios
		//tags= " not @smoketest or @regressiontest" 
		
		)

public class BlazedemoTest1 extends AbstractTestNGCucumberTests {
		
}

