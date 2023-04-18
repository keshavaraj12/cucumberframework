package commanStepDefination;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import genericUtility.WebDriverUtility;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomUtility.Home;
import pomUtility.RegisterForm;

public class Hooks extends BaseClass{

	@Before
	public static void preStep() throws ClassNotFoundException {
		System.out.println("open the browser");
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(cop);
		home=new Home(driver);
		form=new RegisterForm(driver);
		weblib=new WebDriverUtility(driver);
		weblib.useMaximize();
		weblib.useImplicitwait();
		
	}

	@AfterStep(order = 1)
	public void addScreenshot(Scenario scenario) throws IOException{
		if(scenario.isFailed()) {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/image"+LocalDateTime.now().getSecond()+".png");
			FileUtils.copyFile(screenshot, dest);
		}

	}

	@AfterStep(order = 2)
	public void addScreenshot1(Scenario scenario){
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After
	public static void postStep() {
		System.out.println("close the browser");
		weblib.useQuitmethod();
	}


}
