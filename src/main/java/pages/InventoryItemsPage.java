package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryItemsPage extends BasePage {
	    
	
	//Locators************************************************************************************************
	private By verifyStatusOfBtn = By.xpath("//button[contains(@class,'btn_inventory')][contains(text(),'')]");
	private By addToCartBtn = By.cssSelector(".btn_primary.btn_inventory");
	private By removeBtn = By.cssSelector(".btn_secondary.btn_inventory");
	private By clickBackBtn =  By.id("back-to-products");
	private By verifyItemName = By.className("inventory_details_name");
	
	//Constructor*********************************************************************************************
	public InventoryItemsPage(WebDriver driver) {
        super(driver);
				
	}	
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	   
	public void clickAddToCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		WebElement itemName = driver.findElement(verifyItemName);
		System.out.println("Item added from the <Items Page>: " + itemName.getText());	
	
	}
	
	public void clickRemoveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
		WebElement itemName = driver.findElement(verifyItemName);
		System.out.println("Item removed from the <Items Page>: " + itemName.getText());	
	
	}
	
	public void clickBackBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(clickBackBtn)).click();
				
	}

	public String verifyStatusOfBtn() {
		WebElement status =	wait.until(ExpectedConditions.visibilityOfElementLocated(verifyStatusOfBtn));
		System.out.println("The button displays: " + status.getText());
		return status.getText();
		
	}

	public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
				 try {
					 driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]"
					 		+ "/following:: div[@class='inventory_details_price'][contains(.,\"" + itemPrice + "\")]"));
					 System.out.println(itemName + ", $" + itemPrice + " - is listed on <Inventory Items page>");
			            return true;
			        } catch (NoSuchElementException e) {
			        //	e.printStackTrace();
			        	System.out.println(itemName + ", $" + itemPrice + " - is not listed on the <Inventory Items page>");
			            return false;
			        }
			 }		
	
	
}
