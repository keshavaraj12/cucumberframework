package pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;

public class RegisterForm {

	public RegisterForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='inputName']")
	private WebElement name;
	
	@FindBy(xpath = "//input[@id='address']")
	private WebElement address;
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@id='state']")
	private WebElement state;
	
	@FindBy(xpath = "//input[@id='zipCode']")
	private WebElement zipcode;
	
	@FindBy(xpath = "//input[@id='creditCardNumber']")
	private WebElement cardnumber;
	
	@FindBy(xpath = "//input[@id='creditCardMonth']")
	private WebElement cardmounth;
	
	@FindBy(xpath = "//input[@id='creditCardYear']")
	private WebElement cardyear;
	
	@FindBy(xpath = "//input[@id='nameOnCard']")
	private WebElement cardname;
	
	public WebElement getName() {
		return name;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getCardnumber() {
		return cardnumber;
	}

	public WebElement getCardmounth() {
		return cardmounth;
	}

	public WebElement getCardyear() {
		return cardyear;
	}

	public WebElement getCardname() {
		return cardname;
	}

	public void enterTheDetails(DataTable table) throws InterruptedException {
		name.sendKeys(table.row(0).get(1));
		address.sendKeys(table.row(1).get(1));
		city.sendKeys(table.row(2).get(1));
		state.sendKeys(table.row(3).get(1));
		zipcode.sendKeys(table.row(4).get(1));
		Thread.sleep(1000);
		cardnumber.sendKeys(table.row(5).get(1));
		cardmounth.sendKeys(table.row(6).get(1));
		cardyear.sendKeys(table.row(7).get(1));
		cardname.sendKeys(table.row(8).get(1));
		Thread.sleep(2000);

	}
	
}
