package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Checkout2Page {
	private WebDriver driver;
		
	//Locators
	
	private By title = By.className("title");

	private By itemPrice = By.cssSelector(".inventory_item_price");

	private By finishBtn = By.id("finish");

	
	// Constructor
	public Checkout2Page(WebDriver driver) {
		this.driver = driver;
		
	}


	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "User is not on <CHECKOUT: OVERVIEW> page");
		return true;
	}


	public String getTitle() {
		return driver.findElement(title).getText();

	}


	public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
		 try {
			 driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]"
			 		+ "/following:: div[@class='inventory_item_price'][contains(.,\"" + itemPrice + "\")]")).getText();
			 System.out.println(itemName + ", " +  itemPrice + " - is listed on the <CHECKOUT: OVERVIEW> page");
	            return true;
	        } catch (NoSuchElementException e) {
	        //	e.printStackTrace();
	        	System.out.println(itemName + ", " + itemPrice + " - is not listed on the <CHECKOUT: OVERVIEW> page");
	            return false;
	        }
	}


	public Checkout3Page clickFinishBtn() {
		driver.findElement(finishBtn ).click();
		return new Checkout3Page(driver);
		
	}

	public double verifySubtotal() {
        double result = 0;
        List<WebElement> sumOfItems = driver.findElements(itemPrice);
        for (int i = 0; i < sumOfItems.size(); i++) {
            String value = sumOfItems.get(i).getText();
            result = result + Double.parseDouble(value.substring(1, value.length()));
     		}
        return result;
        
	}       
 
	public double verifyTotal() {
		double result = 0, tax, total = 0, s;
	    List<WebElement> sumOfItems = driver.findElements(itemPrice);
	    for (int i = 0; i < sumOfItems.size(); i++) {
	    String value = sumOfItems.get(i).getText();
	    result = result + Double.parseDouble(value.substring(1, value.length()));
	    tax = 8; // means 8%
	    s = 100 + tax; 
	    total = Math.round(s*result)/100.0; 	
	  }
	    return total; 
	    
	}

	public double verifyTax() {
		double result = 0, tax = 0;
	    List<WebElement> sumOfItems = driver.findElements(itemPrice);
	    for (int i = 0; i < sumOfItems.size(); i++) {
	    String value = sumOfItems.get(i).getText();
	    result = result + Double.parseDouble(value.substring(1, value.length()));
	    tax = Math.round(result)*0.08;  // means 8%
	    }
		return tax; 
		
	}

}
