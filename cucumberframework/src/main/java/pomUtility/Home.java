package pomUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Home {

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='jumbotron']//h1")
	private WebElement homepage;
	
	@FindBy(xpath = "//div[@class='jumbotron']//p/a")
	private WebElement beachlink;

	@FindBy(xpath = "//select[@name='fromPort']")
	private WebElement sfrom;
	
	@FindBy(xpath = "//select[@name='toPort']")
	private WebElement sto;
	
	@FindBy(xpath = "//input[@value='Find Flights']")
	private WebElement flightbutton;
	
	@FindBy(xpath="//tr//td[6]")
	private List<WebElement> price;
	
	@FindBy(xpath = "//div[@class='container']/p/em")
	private WebElement totalcost;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement purchaseflight;
	
	@FindBy(xpath = "//tbody//tr/td[.='Id']/following-sibling::td")
	private WebElement id;
	
	public WebElement getHomepage() {
		return homepage;
	}

	public WebElement getBeachlink() {
		return beachlink;
	}

	public WebElement getSfrom() {
		return sfrom;
	}

	public WebElement getSto() {
		return sto;
	}

	public WebElement getFlightbutton() {
		return flightbutton;
	}
	
	public List<WebElement> getPrice() {
		return price;
	}

	public WebElement getTotalcost() {
		return totalcost;
	}

	public WebElement getPurchaseflight() {
		return purchaseflight;
	}

	public WebElement getId() {
		return id;
	}
	
	public Boolean validatehomepage() {
		boolean titledisplayed = homepage.isDisplayed();
		return titledisplayed;	
	}
	
	public void clickbeachlink() {
		beachlink.click();
	}
	
	public String selectDeparture(String i) {
		Select from=new Select(sfrom);
		from.selectByVisibleText(i);
		return i;
	}
	
	public String selectDestination(String j) {
		Select to=new Select(sto);
		to.selectByVisibleText(j);
		return j;
	}
	
	public void clickonflightbotton() {
		flightbutton.click();
	}
	
	public void chooseLowestpriceflight(WebDriver driver) {
		ArrayList<Double> list=new ArrayList();
		for (WebElement p : price) {
			String cost = p.getText().replace('$', ' ');
			Double d=Double.parseDouble(cost);
			list.add(d);
		}
		Collections.sort(list);
		System.out.println(list);
		Double lowprice = list.get(0);
		
		driver.findElement(By.xpath("//tr//td[.='$"+lowprice+"']/..//input[@value='Choose This Flight']")).click();
		
	}
	
	public String validatetotalcost() {
		String cost = totalcost.getText();
		return cost;
	}
	
	public void clickpurchaseflight() {
		purchaseflight.click();
	}
	
	public String printId() {
		String Id = id.getText();
		return Id;
	}
	
}
