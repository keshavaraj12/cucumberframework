package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

	public WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}

	public void useMaximize() {
		driver.manage().window().maximize();
	}
	
	public void useImplicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void useGetmethod(String url) {
		driver.get(url);
	}
	
	public void useNavigateback() {
		driver.navigate().back();
	}
	
	public String useGetcurrenturl() {
		return driver.getCurrentUrl();
	}
	
	public void useQuitmethod() {
		driver.quit();
	}
}
