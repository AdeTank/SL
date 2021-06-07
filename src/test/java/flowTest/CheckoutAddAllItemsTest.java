package flowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest; 

public class CheckoutAddAllItemsTest extends BaseTest  {
	
	
	@Test(priority = 1)
	public void checkoutAddAllItems() throws Exception {
		
		login.logIN("standard_user", "secret_sauce");

		Assert.assertTrue(inventory.getCurrentUrl());
		
		// check the No of items on the <Inventory Page>
		Assert.assertEquals(inventory.getNumberOfItems(), 6, "Number of items is not 6");	
		
		//                                                       String itemName, String itemPrice
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));	
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Bike Light", "9.99"));	
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Bolt T-Shirt", "15.99"));	
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Fleece Jacket", "49.99"));	
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Onesie", "7.99"));	
		Assert.assertTrue(inventory.verifyItemNameAndPrice("Test.allTheThings() T-Shirt (Red)", "15.99"));	
		
		Assert.assertTrue(carti.checkIfCartIsEmpty());
	
		inventory.addAllItems();
		
		Assert.assertEquals(carti.cartCounter(), "6", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());	
		
		carti.clickCartBtn();	
	
		Assert.assertTrue(cart.getCurrentUrl());
		
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));	
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Bike Light", "9.99"));	
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Bolt T-Shirt", "15.99"));	
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Fleece Jacket", "49.99"));	
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Onesie", "7.99"));	
		Assert.assertTrue(cart.verifyItemNameAndPrice("Test.allTheThings() T-Shirt (Red)", "15.99"));	
	
	// click Checkout button	
		cart.clickCheckoutBtn();

		Assert.assertTrue(checkout1.getCurrentUrl());
				
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");
				
		Assert.assertTrue(checkout2.getCurrentUrl());
	
	// verify that names and price of the items are the same on <Checkout2 Page>	
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));	
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Sauce Labs Bike Light", "9.99"));	
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Sauce Labs Bolt T-Shirt", "15.99"));	
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Sauce Labs Fleece Jacket", "49.99"));	
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Sauce Labs Onesie", "7.99"));	
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Test.allTheThings() T-Shirt (Red)", "15.99"));	
		
	// verify Item total, Tax & Total
		Assert.assertEquals(checkout2.verifySubtotal(), 129.94, "Item total value is not correct");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
		
		Assert.assertEquals(checkout2.verifyTax(), 10.4, "Tax value is not correct");
		System.out.println("Tax: $" + checkout2.verifyTax());
		
		Assert.assertEquals(checkout2.verifyTotal(), 140.34, "Item total value is not correct");
		System.out.println("Total: $" + checkout2.verifyTotal());
		
		checkout2.clickFinishBtn();
		
		Assert.assertTrue(checkout3.getCurrentUrl());
	
	// Verify message  
		Assert.assertEquals(checkout3.completeHeader(), "THANK YOU FOR YOUR ORDER");
		System.out.println("Checkout Complete message: " + checkout3.completeHeader());
		
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		 
	}

}