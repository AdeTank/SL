package checkoutInfoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class Checkout2OverviewCancel extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack", price4 = "29.99";

	
	@BeforeClass
	public void Precondition() throws Exception {
/**
 * Precondition: User is logged in and one item is added <Inventory page>, 
 * from <Cart page> click <Checkout> button, 
 * Complete Checkout1: Your Information and click on <Continue> button
 */
			
		login.logIN("standard_user", "secret_sauce");
		
		inventory.clickAddToCartBtn(itemId4);
			
		carti.clickCartBtn();
		cart.clickCheckoutBtn();
		
		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");
			
	}
/**
 * Checkout2: Overview - Step two, 
 * verify url, header, and that item added in Precondition is displayed
 * click <Cancel> button
 * verify that user is back on <Inventory page> & that cart still shows the same No of items
 */

	@Test(priority = 1)
	public void checkoutYourInfo() throws Exception {
				
		Assert.assertTrue(checkout2.getCurrentUrl());
		Assert.assertEquals(checkout2.subheader(), "CHECKOUT: OVERVIEW");
		System.out.println("Subheader: " + checkout2.subheader());	
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		
		checkout2.verifyItemNameAndPrice(itemId4, price4);
							
		Assert.assertEquals(checkout2.verifySubtotal(), 29.99, "Item total value is not correct");
		System.out.println("Item total: $" + checkout2.verifySubtotal());	
		
		checkout2.clickCancelBtn();

		Assert.assertTrue(inventory.getCurrentUrl());
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		
				
	}
		
}
