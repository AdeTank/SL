package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage  extends BasePage {
	
	//Locators ************************************************************************************************
	private By title = By.className("header_secondary_container");
	//buttons
	private By clickCheckoutBtn = By.id("checkout");
	private By clickContinueShoppingBtn = By.id("continue-shopping");
	private By clickRemoveAllItems = By.cssSelector(".btn_secondary.cart_button");
				
	// Constructor *********************************************************************************************
	public CartPage(WebDriver driver) {
        super(driver);
							
	}	
	
		public boolean getCurrentUrl() {
			Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html", "User is not on the <Cart page>");
			return true;
			
	}

		public String title() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
				  
	}
		
		 public void goToCartPage() {
		        driver.get("https://www.saucedemo.com/cart.html");
		        
	}
		
		public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
			try {
				driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]/following:: div[@class='inventory_item_price']"
						+ "[contains(.,\"" + itemPrice + "\")]")).isDisplayed();
				System.out.println(itemName + ", $" + itemPrice + " - is listed on <Cart page>");
		        return true;
		        } catch (NoSuchElementException e) {
		        //	e.printStackTrace();
		        	System.out.println(itemName + ", $" + itemPrice + " - is not listed on the <Cart page>");
		        return false;		        
		    }
			 
	}	 
			 
		public boolean verifyItemName(String itemName) throws Exception {
			try {
				driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,\"" + itemName + "\")]")).isDisplayed(); 
				System.out.println(itemName + " - item is listed on the <Cart page>");
				return true;
				} catch (NoSuchElementException e) {
				//	e.printStackTrace();
				System.out.println(itemName + " - item is not listed on the <Cart page>");
				return false;				
			}
			
	}
		
		public void clickItemName(String itemName) throws Exception {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='inventory_item_name']"
					+ "[contains(.,\"" + itemName + "\")]"))).click();
				
	}		
		
		public void clickRemoveBtn(String itemName) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(.,\"" + itemName + "\")]"
					+ "/following:: button[@class='btn btn_secondary btn_small cart_button'][1]"))).click();
			System.out.println("Item removed from the cart: " + itemName);
					
	}
			
		public void removeAllItems() {
			List<WebElement> removeAllItems = driver.findElements(clickRemoveAllItems);
		    for (WebElement clickRemoveBtn : removeAllItems) { 
		    	clickRemoveBtn.click();  
			}
			
	}
		
		public void clickCheckoutBtn() {
			wait.until(ExpectedConditions.elementToBeClickable(clickCheckoutBtn)).click();
					
	}
	
		public void clickContinueShoppingBtn() {
			wait.until(ExpectedConditions.elementToBeClickable(clickContinueShoppingBtn)).click();
			
	
		}		
}
