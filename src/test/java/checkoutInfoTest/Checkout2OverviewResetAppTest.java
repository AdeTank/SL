package checkoutInfoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class Checkout2OverviewResetAppTest extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack", price4 = "29.99";
	
	@BeforeClass
	public void Precondition() throws Exception {
/**
 * User is logged in with standard_user, 
 * one item is added <Inventory page>, 
 * from <Cart page> click <Checkout> button, 
 * Complete Checkout1: Your Information 
 */
	
		login.logIN("standard_user", "secret_sauce");
	
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId4, price4));
		inventory.clickAddToCartBtn(itemId4);
	
		carti.clickCartBtn();			
		cart.clickCheckoutBtn();	
		
		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");
		
	}
/**
 * Checkout2: Overview - Step two, 
 * verify item name & price & item total
 * click <Reset App> link
 * verify cart is empty
 * item is still displayed
 * refresh the page
 * verify that item is no longer displayed
 * verify that item total is 0
 */

	@Test(priority = 1, groups = {"positive"})
	public void resetAppAndRefresh() throws Exception {
		
		Assert.assertTrue(checkout2.getCurrentUrl());
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());

		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId4, price4));
		
		Assert.assertEquals(checkout2.verifySubtotal(), 29.99, "Item total value is not correct");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
			
		hMenu.clickResetAppStateFromHMenu();
	
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
		// cart is empty, but item is still displayed
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId4, price4));
		
		refresh();
		
		// after refresh item is no longer displayed
		Assert.assertFalse(checkout2.verifyItemNameAndPrice(itemId4, price4));
		
		Assert.assertTrue(carti.checkIfCartIsEmpty());	
			
		Assert.assertEquals(checkout2.verifySubtotal(), 0, "Item total value is not correct");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
		
	}	
	
}
