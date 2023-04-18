package commanStepDefination;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import genericUtility.WebDriverUtility;
import pomUtility.Home;
import pomUtility.RegisterForm;
public class BaseClass {
	
	public static WebDriver driver;
	public static Home home;
	public static RegisterForm form;
	public static WebDriverUtility weblib;
}
