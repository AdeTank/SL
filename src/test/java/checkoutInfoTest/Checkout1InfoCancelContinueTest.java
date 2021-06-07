package checkoutInfoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


public class Checkout1InfoCancelContinueTest extends BaseTest  {

	private String itemId4 = "Sauce Labs Backpack";
	
	@BeforeClass
	public void Precondition() throws Exception {
/**
* Precondition: User is logged in <Login page>, 
* item is added <Inventory page>, 
* from <Cart page> click on <Checkout> button
* Note* test can be run with no items added 
*/		
		
		login.logIN("standard_user", "secret_sauce");
		
		inventory.clickAddToCartBtn(itemId4);
		
		carti.clickCartBtn();
		cart.clickCheckoutBtn();
				
	}
/**
 * Complete Checkout1: Your Information - Step one, 
 * verify url, header & No of items
 * click <Cancel> button, 
 * verify that user is back on <Cart Page> and that number of items is still the same
 * click cart button
 * click <Continue> button
 * verify that user is on <Checkout2: Overview> page
 */

	@Test(priority = 1)
	public void checkoutYourInfoClickCancelAndContinue() {
		
		Assert.assertTrue(checkout1.getCurrentUrl());
		Assert.assertEquals(checkout1.subheader(), "CHECKOUT: YOUR INFORMATION");
		System.out.println("Subheader: " + checkout1.subheader());	
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
			
		checkout1.clickCancelBtn();
					
		// verify that user is back on <Cart Page> and that number of items is still the same
		Assert.assertTrue(cart.getCurrentUrl());
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
			
		cart.clickCheckoutBtn();
			
		// all fields are mandatory, but valid value can be combination of alphabet, numbers or any special character	
		checkout1.checkoutYourInfo("*Test+", "1TEST/", "A*98765");
		
		Assert.assertTrue(checkout2.getCurrentUrl());
					
	
	}
	
}
