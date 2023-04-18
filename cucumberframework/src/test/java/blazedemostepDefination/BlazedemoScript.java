package blazedemostepDefination;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazedemoScript {

	public WebDriver driver;
	@Before
	public void setup() {
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver(cop);
		   System.out.println("open the browser");
		   driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Given("enter the url {string}")
	public void enter_the_url(String url) {
	    driver.get(url);
	}
	
	@Then("validate the home page")
	public void validate_the_home_page() throws InterruptedException {
		boolean titledisplayed = driver.findElement(By.xpath("//div[@class='jumbotron']//h1")).isDisplayed();
		Assert.assertTrue(titledisplayed);
		//Assert.fail();
		Thread.sleep(1000);
	}
	
	@When("click on beach link")
	public void click_on_beach_link() {
		driver.findElement(By.xpath("//div[@class='jumbotron']//p/a")).click();
	}
	
	@Then("validate the beach link page")
	public void validate_the_beach_link_page() throws InterruptedException {
		String hyperlinkurl = driver.getCurrentUrl();
		Assert.assertTrue(hyperlinkurl.contains("vacation"));
		Thread.sleep(1000);
	}
	
	@Then("back to home page")
	public void back_to_home_page() {
		driver.navigate().back();
	}
	
	//@When("^select Departure city (.*)$")
	@When("select Departure city from")
	public void select_departure_city_from(String from) {
		Select sfrom=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		sfrom.selectByVisibleText(from);
	}
	
	//@When("^select Destination city (.*)$")
	@When("select Destination city to")
	public void select_destination_city_to(String to) {
		Select sto=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		sto.selectByVisibleText(to);
	}
	
	@When("select Departure city {string}")
	public void select_departure_city(String from) {
		Select sfrom=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		sfrom.selectByVisibleText(from);
	}
	
	@When("select Destination city {string}")
	public void select_destination_city(String to) {
		Select sto=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		sto.selectByVisibleText(to);
	}
	
	@When("click on flight button")
	public void click_on_flight_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		Thread.sleep(1000);
	}
	
	@When("click on choose flight with lowest price")
	public void click_on_choose_flight_with_lowest_price() throws InterruptedException {
		List<WebElement> price = driver.findElements(By.xpath("//tr//td[6]"));
		ArrayList<Double> list=new ArrayList<Double>();
		for (WebElement p : price) {
			String cost = p.getText().replace('$', ' ');
			Double d=Double.parseDouble(cost);
			list.add(d);
		}
		Collections.sort(list);
		System.out.println(list);
		Double lowprice = list.get(0);
		driver.findElement(By.xpath("//tr//td[.='$"+lowprice+"']/..//input[@value='Choose This Flight']")).click();
		Thread.sleep(2000);

	}
	
	@Then("validate the total cost")
	public void validate_the_total_cost() {
		String totalcost = driver.findElement(By.xpath("//div[@class='container']/p/em")).getText();
		Assert.assertTrue(true,"Total cost: "+totalcost);	
	}
	
	@When("enter the details")
	public void enter_the_details(DataTable table) throws InterruptedException {
		//form[@method='POST']//div[@class='controls']//input[@id='inputName']
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys(table.row(0).get(1));
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(table.row(1).get(1));
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(table.row(2).get(1));
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys(table.row(3).get(1));
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys(table.row(4).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys(table.row(5).get(1));
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys(table.row(6).get(1));
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys(table.row(7).get(1));
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys(table.row(8).get(1));
		Thread.sleep(2000);
	}
	
	
	@When("click on purchase flight")
	public void click_on_purchase_flight() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		Thread.sleep(3000);
	}

	@Then("validate cofirmation")
	public void validate_cofirmation() throws InterruptedException {
		String confiramationurl = driver.getCurrentUrl();
		Assert.assertTrue(confiramationurl.contains("confirmation"));
		Thread.sleep(1000);
		
	}
	
	@Then("get id")
	public void get_id() {
		String id = driver.findElement(By.xpath("//tbody//tr/td[.='Id']/following-sibling::td")).getText();
		Reporter.log("Id="+id, true);
	}
	
	
	@After
	public void poststep() {
		System.out.println("close the browser");
		driver.quit();
	}
	
}
