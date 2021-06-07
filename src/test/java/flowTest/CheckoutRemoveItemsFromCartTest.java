package flowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CheckoutRemoveItemsFromCartTest extends BaseTest  {

	@Test(priority = 1)
	public void removeItemsFromCartAndFinishTest() throws Exception {

		login.logIN("standard_user", "secret_sauce");
		
		Assert.assertTrue(inventory.getCurrentUrl());
			
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));
		
	// Add item
		inventory.clickAddToCartBtn("Sauce Labs Backpack");
	 
	//	Check that number of items in cart displays 1	 
	 	Assert.assertEquals(carti.cartCounter(), "1", ("Cart is not showing correct number of items"));
		System.out.println("Number of items in the cart: " + carti.cartCounter());
	
		carti.clickCartBtn();	
		Assert.assertTrue(cart.getCurrentUrl());
		
	//verify the item name and price added to the <Inventory Page>, are now displayed on the <Cart Page> 	
					        //String "Name of the item", String "Price of the item"
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));	

	// remove item
		cart.clickRemoveBtn("Sauce Labs Backpack");
		
		Assert.assertFalse(cart.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));	
	
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		 
		cart.clickCheckoutBtn();
	
		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");

		Assert.assertTrue(checkout2.getCurrentUrl());
		
		// verify that Item Total, Tax & Total is 0	
				Assert.assertEquals(checkout2.emptySubtotal(), "Item total: $0", "Item total is not correct");
				System.out.println(checkout2.emptySubtotal());	
				
				Assert.assertEquals(checkout2.emptyTax(), "Tax: $0.00", "Tax value is not correct");
				System.out.println(checkout2.emptyTax());	
				
				Assert.assertEquals(checkout2.emptyTotal(), "Total: $0.00", "Total value is not correct");
				System.out.println(checkout2.emptyTotal());	
				
		checkout2.clickFinishBtn();
						
		Assert.assertTrue(checkout3.getCurrentUrl());
		
	// Verify message  
		Assert.assertEquals(checkout3.completeHeader(), "THANK YOU FOR YOUR ORDER");
		System.out.println("Checkout Complete message: " + checkout3.completeHeader());
					
		Assert.assertTrue(carti.checkIfCartIsEmpty());
	
	
	}
	
}
