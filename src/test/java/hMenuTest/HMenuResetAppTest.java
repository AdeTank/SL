package hMenuTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


	public class HMenuResetAppTest extends BaseTest  {
		
		private String itemId4 = "Sauce Labs Backpack";
	
	@BeforeClass
	public void Precondition() throws Exception {
/**
* 	Precondition: User is logged in and on the <Inventory page> 1 item is added to the Cart	
*/			
		login.logIN("standard_user", "secret_sauce");
		
		Assert.assertTrue(inventory.getCurrentUrl());
		inventory.clickAddToCartBtn(itemId4);
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart before reset: " + carti.cartCounter());
		
	}
/**
* Click <Reset App State> link	
* verify that cart is empty
*/
							
		@Test(priority = 1, groups = {"positive"})
		public void hMenuResetAppState() {
							
			// From Hamburger menu select <Reset App State> link	
				hMenu.clickResetAppStateFromHMenu();
								
			// check if cart is empty after <Reset App State>
				Assert.assertTrue(carti.checkIfCartIsEmpty());
							
				
	}
		
}
