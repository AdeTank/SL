package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Checkout3CompletePage extends BasePage {
	
	
	//Locators************************************************************************************************ 
	private By subheader = By.className("header_secondary_container");
	private By completeHeader = By.className("complete-header");
	private By backHomeBtn = By.id("back-to-products");
		
	
	//Constructor*********************************************************************************************
	public Checkout3CompletePage(WebDriver driver) {
        super(driver);
        
    }
	
	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "User is not on the <Finish> page");	
		System.out.println("Current Page: " + subheader());
		return true;
		
	}
	
	public String subheader() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(subheader)).getText();
		
	}
	
	public void goToCheckout3Page() {
		driver.get("https://www.saucedemo.com/checkout-complete.html");
		
	}
	 
	public String completeHeader() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
			
	}

	public void clickBackHomeBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(backHomeBtn)).click();
		
	}
		
		
}
