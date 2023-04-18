package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/main/java/featureFile/Blazedemo.feature:8:23:24:27"},
		glue = {"blazedemostepDefination"},
		dryRun=false,
		monochrome = true,
		publish=true,
		plugin = {"pretty","html:Reports//cucumber-reports.html","json:Reports/cucumber-reports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}		
		)

public class FailedTestRun extends AbstractTestNGCucumberTests{

}
