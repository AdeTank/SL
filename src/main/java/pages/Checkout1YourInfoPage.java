package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Checkout1YourInfoPage extends BasePage {
			
	//Locators************************************************************************************************
	private By subheader = By.className("header_secondary_container");
	private By enterFirstName = By.id("first-name");
	private By enterLastName = By.id("last-name");
	private By enterPostalCode = By.id("postal-code");
	private By clickContinueBtn = By.id("continue");
	private By errorTextCheckout = By.cssSelector("h3");
	private By clickCancelBtn = By.id("cancel");
		
	//Constructor**********************************************************************************************
	public Checkout1YourInfoPage(WebDriver driver) {
        super(driver);
        
    }
	
	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "User is not on the "
				+ "<Checkout: Your Information> page");
		System.out.println("Current Page: " + subheader());
		return true;
		
	}

		public String subheader() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(subheader)).getText();
			
	}
		
		public void goToCheckout1Page() {
			 driver.get("https://www.saucedemo.com/checkout-step-one.html");
			
	}

		public void checkoutYourInfo(String fName, String lName, String postalCode) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(enterFirstName)).sendKeys(fName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(enterLastName)).sendKeys(lName);
			wait.until(ExpectedConditions.visibilityOfElementLocated(enterPostalCode)).sendKeys(postalCode);
			wait.until(ExpectedConditions.elementToBeClickable(clickContinueBtn)).click();
			
	}	
				
		public String errorText() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(errorTextCheckout)).getText();
			
	}
		
		public void clickCancelBtn() {
			wait.until(ExpectedConditions.elementToBeClickable(clickCancelBtn)).click();
			
	}
		
					
}		
