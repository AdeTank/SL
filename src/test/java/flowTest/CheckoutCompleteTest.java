package flowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest; 

public class CheckoutCompleteTest extends BaseTest  {
	
	protected String itemId4 = "Sauce Labs Backpack", price4 = "29.99";
	
	
	@Test(priority = 1)
	public void checkoutComplete() throws Exception {
		
		login.logIN("standard_user", "secret_sauce");
		
		Assert.assertTrue(inventory.getCurrentUrl());
		
		inventory.verifyItemNameAndPrice(itemId4, price4);	

		Assert.assertTrue(carti.checkIfCartIsEmpty());
	
	// Add item
		inventory.clickAddToCartBtn(itemId4);
	 
	//	Check that number of items in cart displays 1	 
	 	Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
	
		carti.clickCartBtn();	
		Assert.assertTrue(cart.getCurrentUrl());
	
	// check the item name and price added to the <Inventory Page>, that are now displayed on the <Cart Page>
		cart.verifyItemNameAndPrice(itemId4, price4);	
	
		cart.clickCheckoutBtn();
	
		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Labs", "AAA111aaa");
		
		Assert.assertTrue(checkout2.getCurrentUrl());
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		
		checkout2.verifyItemNameAndPrice(itemId4, price4);	
			
		// verify that subtotal, tax & total
		Assert.assertEquals(checkout2.verifySubtotal(), 29.99, "Item total value is not correct");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
		
		Assert.assertEquals(checkout2.verifyTax(), 2.40, "Tax value is not correct");
		System.out.println("Tax: $" + checkout2.verifyTax());
		
		Assert.assertEquals(checkout2.verifyTotal(), 32.39, "Total value is not correct");
		System.out.println("Total: $" + checkout2.verifyTotal());
		
		checkout2.clickFinishBtn();
		
		Assert.assertTrue(checkout3.getCurrentUrl());
				
	// Verify message  
		Assert.assertEquals(checkout3.completeHeader(), "THANK YOU FOR YOUR ORDER");
		System.out.println("Checkout Complete message: " + checkout3.completeHeader());
					
	// check that cart is empty
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		 
	}

}