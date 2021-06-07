package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

	public class LoginPage extends BasePage {
	
	// Locators ************************************************************************************************ 
	private By logBtn = By.id("login-button");
	private By password = By.id("password");
	private By username = By.id("user-name");
	private By errorText = By.cssSelector("h3");
	private By clickErrorBtn = By.className("error-button");

	// Constructor *********************************************************************************************
	public LoginPage(WebDriver driver) {
		super(driver);
    
	}
	
	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "User is not on <Login page>");
		return true;	
		
	}
		
	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), "Swag Labs", "<Swag Labs> is not shown");
		System.out.println(driver.getTitle());
		
	}
	
	public void logIN(String name, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(logBtn)).click();
	
	}
		
	public String errorText() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorText)).getText();
		
	}
	
	public void clickErrorBtn()  {
		List<WebElement> cartCounter1  = driver.findElements(errorText);
			if(cartCounter1.size() != 0) {
				driver.findElement(clickErrorBtn).click();
				System.out.println("Error message is closed");
			} else {
				System.out.println("Error message is not displayed");
			}
	}
	
	
}
