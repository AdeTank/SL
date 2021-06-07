package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Checkout2OverviewPage extends BasePage {
		
	//Locators************************************************************************************************ 
	private By subheader = By.className("header_secondary_container");
	private By finishBtn = By.id("finish");
	private By clickCancelBtn = By.id("cancel");
	private By itemPrice = By.cssSelector(".inventory_item_price");
	private By subtotal = By.className("summary_subtotal_label");
	private By tax = By.className("summary_tax_label");
	private By total = By.className("summary_total_label");
		
	private String clickItemName = "//div[@class='inventory_item_name'][contains(text(),'%s')]";
	
	//Constructor*********************************************************************************************
	public Checkout2OverviewPage(WebDriver driver) {
        super(driver);
        
    }
	
	public boolean getCurrentUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html",
				"User is not on the <Checkout: Overview> page");
		System.out.println("Current Page: " + subheader());
		return true;
		
	}

	public String subheader() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(subheader)).getText();
		
	}
	
	public void goToCheckout2Page() {
		 driver.get("https://www.saucedemo.com/checkout-step-two.html");
		
	}
	
		public void clickFinishBtn() {
			wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
					
	}
		
		public void clickItemName(String itemName) throws Exception {
		//	driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,\"" + itemName + "\")]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(clickItemName, itemName)))).click();
			System.out.println("<Inventory Item Page> open for item: " + itemName);
						
	}
		
		public void clickCancelBtn() {
			wait.until(ExpectedConditions.elementToBeClickable(clickCancelBtn)).click(); 
					
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
		 
		public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
			try {
				driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]/following:: div[@class='inventory_item_price']"
					+ "[contains(.,\"" + itemPrice + "\")]"));
			System.out.println(itemName + ", $" + itemPrice + " - is listed on the <Checkout Overview> page");
		            return true;
		        } catch (NoSuchElementException e) {
		        //	e.printStackTrace();
		        	System.out.println(itemName + ", $" + itemPrice + " - is not listed on the <Checkout Overview> page");
		            return false;
		            
		        }
							
	}
	
		public String emptySubtotal() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(subtotal)).getText();
					
	}
		
		public String emptyTax() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(tax)).getText();
			
	}
		
		public String emptyTotal() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(total)).getText();
			
	}
		
		
}
