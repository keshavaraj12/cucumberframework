package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features = {"C:\\Users\\HP\\git\\cucumberrepository\\cucumberframework\\src\\main\\java\\featureFile\\Blazedemo.feature"},
			glue = {"blazedemostepDefination"},
			dryRun=false,
			monochrome = true,
			publish=true,
			plugin = {"pretty","html:Reports//cucumber-reports.html","json:Reports/cucumber-reports.json",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:Reports/FailedReport/failedRerun.txt"},
			tags= "@smoketest or not @regressiontest"
			
			)

	public class Test1 extends AbstractTestNGCucumberTests {
			
	}

