package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class CartPage {
	
	private WebDriver driver;
	

	//Locators
	
	private By title = By.className("title");

	private By checkoutBtn = By.id("checkout");
	
	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		
		
		
	}

	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html", "User is not on <YOUR CART> page");
		return true;
		
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.findElement(title).getText();

	}

	public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
			 try {
				 driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]"
				 		+ "/following:: div[@class='inventory_item_price'][contains(.,\"" + itemPrice + "\")]")).getText();
				 System.out.println(itemName + ", " +  itemPrice + " - is listed on the <YOUR CART> page");
		            return true;
		        } catch (NoSuchElementException e) {
		        //	e.printStackTrace();
		        	System.out.println(itemName + ", " + itemPrice + " - is not listed on the <YOUR CART> page");
		            return false;
		        }
	}

	public Checkout1Page clickCheckoutBtn() {
		driver.findElement(checkoutBtn).click();
		return new Checkout1Page(driver);
	}

}
