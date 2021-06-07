package cartTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


public class CartBasicTest extends BaseTest  {
	
	private String itemId0 = "Sauce Labs Bike Light", price0 = "9.99";
	
	
	@BeforeClass

	public void Precondition() throws Exception {
/**
 * Precondition: User is logged in
 * one item is added <Inventory page>
 */
		
		login.logIN("standard_user", "secret_sauce");
		
		Assert.assertTrue(inventory.getCurrentUrl());
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));
		inventory.clickAddToCartBtn(itemId0);
		
		carti.clickCartBtn();
		
	}
/**
* verify url & subheader - <Your Cart>	
*/
		@Test(priority = 1)
		public void verifyUrlAndSubheader() throws Exception {
		
			Assert.assertTrue(cart.getCurrentUrl());
						
			Assert.assertEquals(cart.title(), "YOUR CART");
			System.out.println("Page Title - " + cart.title());
						
	}	 
/**
* verify that item added on <Inventory Page> is the same on <Cart Page>
* click <Remove> button	for item 
* check if cart is empty
*/
		
		@Test(priority = 2)
		public void clickRemoveBtn() throws Exception {
			
		// verify item name and price that are added on <Inventory Page>, that are now shown on <Cart Page>
			Assert.assertTrue(cart.verifyItemNameAndPrice(itemId0, price0));
	
			Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
			System.out.println("Number of items in the cart: " + carti.cartCounter());
				
			cart.clickRemoveBtn(itemId0);
			
			Assert.assertFalse(cart.verifyItemName(itemId0), "The item is displayed on the <Cart Page>");	
									
			Assert.assertTrue(carti.checkIfCartIsEmpty());
			
	}
/**
* click <Continue Shopping> button, 
* verify that user is back on <Inventory page>	
* add another item and return to <Cart page> 
* click <Checkout> button
* verify that user is on <Checkout Your Info Page>
*/
		
		@Test(priority = 3)
		public void clickContinueAndCheckoutBtn() throws Exception {
			
			Assert.assertTrue(cart.getCurrentUrl());
			cart.clickContinueShoppingBtn(); // back to <Inventory Page>
			
			Assert.assertTrue(inventory.getCurrentUrl());
					
			carti.clickCartBtn();
			Assert.assertTrue(cart.getCurrentUrl());
						
			cart.clickCheckoutBtn(); // forward to <Checkout Your Info Page>
			
			Assert.assertTrue(checkout1.getCurrentUrl());
		
			
	}

	
}
