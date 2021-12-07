package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	private WebDriver driver;

	// Locators ************************************************************************************************ 
		private By logBtn = By.id("login-button");
		private By password = By.id("password");
		private By username = By.id("user-name");
		
	
		// Constructor *********************************************************************************************
		public LoginPage(WebDriver driver) {
			this.driver = driver;
	    
		}

		public boolean getCurrentUrl() {
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "User is not on the <Login> page");
			return true;
			
		}
				
		public void enterUsername(String name) {
			driver.findElement(username).sendKeys(name); 
		
			
		}

		public void enterPassword(String pass) {
			driver.findElement(password).sendKeys(pass);
			
		}

		public ProductsPage clickLoginBtn() {
			driver.findElement(logBtn).click();
			return new ProductsPage(driver);

		}

			
}
