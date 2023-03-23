package commanStepDefination;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import genericUtility.WebDriverUtility;
import pomUtility.Home;
import pomUtility.RegisterForm;
public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentReports repoter;
	public static ExtentTest test;
	public static Home home;
	public static RegisterForm form;
	public static WebDriverUtility weblib;
	

}
