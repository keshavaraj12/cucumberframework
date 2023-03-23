package commanStepDefination;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import genericUtility.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomUtility.Home;
import pomUtility.RegisterForm;

public class Hooks extends BaseClass{
	
	@Before
	public static void preStep() {
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
	
	@After
	public static void postStep() {
		System.out.println("close the browser");
		weblib.useQuitmethod();
	}

}
