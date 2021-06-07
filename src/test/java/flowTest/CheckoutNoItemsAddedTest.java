package flowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CheckoutNoItemsAddedTest extends BaseTest  {

	@Test(priority = 1)
	public void checkoutNoItemsAdded() throws Exception {

		login.logIN("standard_user", "secret_sauce");
		
		Assert.assertTrue(inventory.getCurrentUrl());
	
		Assert.assertTrue(carti.checkIfCartIsEmpty());
			
		carti.clickCartBtn();	
		Assert.assertTrue(cart.getCurrentUrl());
		cart.clickCheckoutBtn();

		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");

		Assert.assertTrue(checkout2.getCurrentUrl());
		
	// verify that subtotal value is 0,00	
		Assert.assertEquals(checkout2.emptySubtotal(), "Item total: $0", "Item total is not correct");
		System.out.println(checkout2.emptySubtotal());	
		
		checkout2.clickFinishBtn();
		
		Assert.assertTrue(checkout3.getCurrentUrl());
		
	// Verify message  
		Assert.assertEquals(checkout3.completeHeader(), "THANK YOU FOR YOUR ORDER");
		System.out.println("Checkout Complete message: " + checkout3.completeHeader());
					
	// check if the cart is empty
		Assert.assertTrue(carti.checkIfCartIsEmpty());
	
	
	}
	
}
