package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Checkout1Page {

	private WebDriver driver;
	
	//Locators
	
	private By title = By.className("title");

	private By firstName = By.id("first-name");

	private By lastName = By.id("last-name");

	private By zipCode = By.id("postal-code");

	private By continueBtn = By.id("continue");
	
	// Constructor
	
		public Checkout1Page(WebDriver driver) {
			this.driver = driver;

	
	}

	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "User is not on the <CHECKOUT: YOUR INFORMATION> page");
		return true;
		
	}

	public String getTitle() {
		return driver.findElement(title).getText();

	}

	public void enterFirstName(String fname) {
		driver.findElement(firstName).sendKeys(fname); 
		
	}

	public void enterLastName(String lname) {
		driver.findElement(lastName).sendKeys(lname); 
		
	}

	public void enterZipCode(String zip) {
		driver.findElement(zipCode).sendKeys(zip); 
		
	}

	public Checkout2Page clickContinueBtn() {
		driver.findElement(continueBtn).click();
		return new Checkout2Page(driver);
	}

}
