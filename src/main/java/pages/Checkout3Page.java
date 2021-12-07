package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Checkout3Page {
	private WebDriver driver;
	
	
	//Locator
	
	private By title = By.className("title");

	private By successMessage = By.cssSelector(".complete-header");

	private By hMenu = By.id("react-burger-menu-btn");

	private By logout = By.id("logout_sidebar_link");


	private By cartCounter = By.className("shopping_cart_badge");

	
	// Constructor

	public Checkout3Page(WebDriver driver) {
		this.driver = driver;
		
	}


	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "User is not on <CHECKOUT: COMPLETE!> page");
		return true;
		
	}

	public String getTitle() {
		return driver.findElement(title).getText();
		
	}

	public String successMessage() {
		return driver.findElement(successMessage).getText();
		
	}

	public void clickHMenu() {
		driver.findElement(hMenu).click();
		
	}

	public void clickLogoutLink() {
		driver.findElement(logout).click();
		
	}
     
	public boolean cartNumber() {
		try {
			if (driver.findElement(cartCounter).isDisplayed()) {
				 System.out.println("Cart is not empty");
				return true;
			}
			else {
				return false;
			}
		} 
		catch (NoSuchElementException e) {
			System.out.println("Cart is empty");
			return false;
			
		}
		 
	}		
}
	


