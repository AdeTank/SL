package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage {

	private WebDriver driver;

		
	//Locators
	private By title = By.className("title");

	private By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");

	private By cartCounter = By.className("shopping_cart_badge");

	private By cartBtn = By.id("shopping_cart_container");

	private By verifyStatusOfBtn = By.xpath("//button[contains(@id,'sauce-labs-backpack')][contains(text(),'')]");


	private By sauceLabsBackpackName = By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name']");
		
	// Constructor *********************************************************************************************
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
			    
	}

		public String getPageTitle() {
			System.out.println("Page title is : " + driver.getTitle());
			return driver.getTitle();
			
	}

		public boolean getCurrentUrl() {
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "User is not on <PRODUCTS> page");
			return true;
			
	}
		
		public String getTitle() {
			return driver.findElement(title).getText();
					
	}
				
		public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
			 try {
				 driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]"
						+ "/following:: div[@class='inventory_item_price'][contains(.,\"" + itemPrice + "\")]")).getText();
				 System.out.println(itemName + ", " +  itemPrice + " - is listed on the <Products> page");
				 return true;
				 } catch (NoSuchElementException e) {
				        //	e.printStackTrace();
				       System.out.println(itemName + ", " + itemPrice + " - is not listed on the <Products> page");
				            return false;
				        }
	}

		public void addToCartSauceLabsBackpack() {
			String itemName = driver.findElement(sauceLabsBackpackName ).getText();
			driver.findElement(sauceLabsBackpack).click();
			System.out.println("Item added from the <PRODUCTS> page: " + itemName);
					
	}
		
		public String cartCounter() {
		WebElement status = driver.findElement(cartCounter);
		System.out.println("Number of items in the Cart: " + status.getText());
		return status.getText();
		
	}

		public CartPage clickCartBtn() {
			driver.findElement(cartBtn).click();
			return new CartPage(driver);
					
	}

		public String verifyStatusOfBtn() {
			WebElement status = driver.findElement(verifyStatusOfBtn);
			System.out.println("The button displays: " + status.getText());
			return status.getText();
			
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

	


