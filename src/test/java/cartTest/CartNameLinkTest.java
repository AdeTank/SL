package cartTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class CartNameLinkTest  extends BaseTest  {
	
	private String itemId0 = "Sauce Labs Bike Light", price0 = "9.99";

	@BeforeClass

	public void Precondition() throws Exception {
			
/**
 * Precondition: User is logged in
 * <Inventory page> one item is added 
 */
	
		login.logIN("standard_user", "secret_sauce");
				
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));
		inventory.clickAddToCartBtn(itemId0);
				
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		carti.clickCartBtn();
	
}
/**
* click an item name/link "Sauce Labs Bike Light"
* verify that <Inventory Items> page is open 
* verify name & price of the product is the same
* verify that default status of the button is Remove
* click <Back> button 
* verify that user is back on the <Inventory Page>
*/
	
		@Test(priority = 1)
		public void clickNameOfItem() throws Exception {
						
			Assert.assertTrue(cart.verifyItemNameAndPrice(itemId0, price0));	
			cart.clickItemName(itemId0);
			
		// each item has its own page depending on the item id,     for example „Sauce Labs Bike Light“ - id=0
			Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", 
					"User is not on <Inventory Items> page");
						
			Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId0, price0));	
						
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<Remove> button is not shown");		
				
			itemsPage.clickBackBtn();
		
			Assert.assertTrue(inventory.getCurrentUrl());
						
			Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
	
		}

/**
* click an item name 
* verify that <Inventory Items> page is open 
* verify name & price of the product is the same
* verify that default status of the button is Remove
* click the Remove button
* verify that button now shows <Add to cart>
* click back button
* verify that user is on Inventory Page
* verify that cart is empty
*/
		
		@Test(priority = 2)
		public void clickNameOfItemAndRemove() throws Exception {
					
			Assert.assertTrue(cart.verifyItemNameAndPrice(itemId0, price0));			
		
			cart.clickItemName(itemId0);
						
			Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", 
					"User is not on <Inventory Items> page");
						
			Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId0, price0));	
						
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<Remove> button is not shown");		
				
			itemsPage.clickRemoveBtn();
			
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<Add to cart> button is not shown");		
			
			itemsPage.clickBackBtn();
				
			Assert.assertTrue(inventory.getCurrentUrl());
	
			Assert.assertTrue(carti.checkIfCartIsEmpty());
		
	}
	
}

