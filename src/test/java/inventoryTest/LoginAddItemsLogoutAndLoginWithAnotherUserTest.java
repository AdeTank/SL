package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginAddItemsLogoutAndLoginWithAnotherUserTest extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack";
	
/**
 * Login with standard_user
 * add one item
 * verify that cart displays 1
 * logout from hMenu
 * login with performance_glitch_user
 * verify that data is not lost, cart still displays 1
 * click Reset App
 * verify that cart is empty
 * logout and login with standard_user
 * verify that cart is empty 
 */
	
	
	@Test(priority = 1, groups = {"negative"})
	public void loginAddItemLogoutAndLoginWithAnotherUser() throws Exception {

		login.logIN("standard_user", "secret_sauce");

	Assert.assertTrue(inventory.getCurrentUrl());
			
	Assert.assertTrue(carti.checkIfCartIsEmpty());
	
		inventory.clickAddToCartBtn(itemId4);
	 
	Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		hMenu.clickLogoutFromHMenu();

	Assert.assertTrue(login.getCurrentUrl());
		login.logIN("performance_glitch_user", "secret_sauce");
								
	Assert.assertTrue(inventory.getCurrentUrl());
	
	Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		
	// From H Menu select <Reset App State> link	
		hMenu.clickResetAppStateFromHMenu();
			
	// check if cart is empty after <Reset App State>
	Assert.assertTrue(carti.checkIfCartIsEmpty());

		hMenu.clickLogoutFromHMenu();

	Assert.assertTrue(login.getCurrentUrl());
		login.logIN("standard_user", "secret_sauce");
			
	Assert.assertTrue(inventory.getCurrentUrl());
		
	Assert.assertTrue(carti.checkIfCartIsEmpty());
		
	}
	
}
