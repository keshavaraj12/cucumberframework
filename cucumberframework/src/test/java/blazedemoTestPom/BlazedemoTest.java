package blazedemoTestPom;

import org.testng.Assert;
import org.testng.Reporter;

import commanStepDefination.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlazedemoTest extends BaseClass{
		
	@Given("enter the url {string}")
	public void enter_the_url(String url) {
	    weblib.useGetmethod(url);
	}
	
	@Then("validate the home page")
	public void validate_the_home_page() throws InterruptedException {
		boolean title=home.validatehomepage();
		Assert.assertTrue(title);
		Thread.sleep(1000);
	}
	
	@When("click on beach link")
	public void click_on_beach_link() {
		home.clickbeachlink();
	}
	
	@Then("validate the beach link page")
	public void validate_the_beach_link_page() throws InterruptedException {
		String hyperlinkurl = weblib.useGetcurrenturl();
		Assert.assertTrue(hyperlinkurl.contains("vacation"));	
		Thread.sleep(1000);
	}
	
	@Then("back to home page")
	public void back_to_home_page() {
		weblib.useNavigateback();
	}
	
	@When("select Departure city from")
	public void select_departure_city_from(String from) {
		home.selectDeparture(from);
	}
	
	@When("select Destination city to")
	public void select_destination_city_to(String to) {
		home.selectDestination(to);
	}
	
	@When("select Departure city {string}")
	public void select_departure_city(String from) {
		home.selectDeparture(from);
	}
	
	@When("select Destination city {string}")
	public void select_destination_city(String to) {
		home.selectDestination(to);
	}
	
	@When("click on flight button")
	public void click_on_flight_button() throws InterruptedException {
		home.clickonflightbotton();
		Thread.sleep(1000);
	}
	
	@When("click on choose flight with lowest price")
	public void click_on_choose_flight_with_lowest_price() throws InterruptedException {
		home.chooseLowestpriceflight(driver);
		Thread.sleep(2000);
	}
	
	@Then("validate the total cost")
	public void validate_the_total_cost() {
		String totalcost = home.validatetotalcost();
		Assert.assertTrue(true,"Total cost: "+totalcost);
		Assert.fail();
	}
	
	@When("enter the details")
	public void enter_the_details(DataTable table) throws InterruptedException {
		form.enterTheDetails(table);
	}
	
	@When("click on purchase flight")
	public void click_on_purchase_flight() {
		home.clickpurchaseflight();
	}

	@Then("validate cofirmation")
	public void validate_cofirmation() throws InterruptedException {
		String confiramationurl =weblib.useGetcurrenturl();
		Assert.assertTrue(confiramationurl.contains("confirmation"));
		Thread.sleep(1000);	
	}
	
	@Then("get id")
	public void get_id() {
		String id = home.printId();
		Reporter.log("Id="+id, true);
	}
	

}
