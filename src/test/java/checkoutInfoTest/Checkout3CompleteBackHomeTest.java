package checkoutInfoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class Checkout3CompleteBackHomeTest extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack";
	
	@BeforeClass
	public void Precondition() throws Exception {
/**
 * User is logged in with standard_user, 
 * one item is added <Inventory page>, 
 * from <Cart page> click <Checkout> button, 
 * Complete Checkout1: Your Information 
 * Checkout2: Overview - Step two - click <Finish> button
 */
 
	
		login.logIN("standard_user", "secret_sauce");
			
		inventory.clickAddToCartBtn(itemId4);
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
	
		carti.clickCartBtn();			
		cart.clickCheckoutBtn();	
				
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");
		
		checkout2.clickFinishBtn();
		
	}
/**
 * Checkout3: Complete  
 * verify that user is on <Checkout3: Complete> page
 * verify header
 * check that cart is empty
 * click <Back Home> button
 * verify that user is back on the <Inventory> page
 */

	@Test(priority = 1, groups = {"positive"})
	public void resetAppAndRefresh() throws Exception {
				
		Assert.assertTrue(checkout3.getCurrentUrl());
		
		// Verify message  
		Assert.assertEquals(checkout3.completeHeader(), "THANK YOU FOR YOUR ORDER");
		System.out.println("Checkout Complete message: " + checkout3.completeHeader());
						
		// check that cart is empty
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
		// click <Back Home> button
		checkout3.clickBackHomeBtn();
				
		// verify that user is back on the <Inventory> page
		Assert.assertTrue(inventory.getCurrentUrl());
		
	}	
	
}
