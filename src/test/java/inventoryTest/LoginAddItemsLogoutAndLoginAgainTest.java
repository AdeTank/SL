package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginAddItemsLogoutAndLoginAgainTest extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack";

	/**
	 * Login with standard_user,
	 * add one item,
	 * logout, and then log in with the same user
	 * verify that data is not lost, cart still shows 1
	 * remove item
	 * check that cart is empty
	*/
	
	@Test(priority = 1, groups = {"positive"})
	public void loginAddItemLogoutAndLoginAgainTest() throws Exception {

			login.logIN("standard_user", "secret_sauce");

		Assert.assertTrue(inventory.getCurrentUrl());
		
		Assert.assertTrue(carti.checkIfCartIsEmpty());
	
			inventory.clickAddToCartBtn(itemId4);
	 
	 	Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
			hMenu.clickLogoutFromHMenu();
	
		Assert.assertTrue(login.getCurrentUrl());
		
			login.logIN("standard_user", "secret_sauce");		
				
		Assert.assertTrue(inventory.getCurrentUrl());

		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart after re-login: " + carti.cartCounter());

			inventory.clickRemoveBtn(itemId4);
		
		Assert.assertTrue(carti.checkIfCartIsEmpty());
				
			hMenu.clickLogoutFromHMenu();
	
	}
	/**
	 * Login with standard_user,
	 * add one item,
	 * click <Reset App State>
	 * check that cart is empty
	 * logout, and then log in with the same user
	 * check that cart is empty
	*/
	
	@Test(priority = 2)
	public void loginAddItemsLogoutLoginAgainResetTest() throws Exception {
		
		login.logIN("standard_user", "secret_sauce");	
		
	Assert.assertTrue(inventory.getCurrentUrl());
					
		inventory.clickAddToCartBtn(itemId4);
	
	Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
				
		hMenu.clickResetAppStateFromHMenu();
		
	Assert.assertTrue(carti.checkIfCartIsEmpty());
	
		hMenu.clickLogoutFromHMenu();
		
	Assert.assertTrue(login.getCurrentUrl());
	
		login.logIN("standard_user", "secret_sauce");	
				
	Assert.assertTrue(inventory.getCurrentUrl());
		
	Assert.assertTrue(carti.checkIfCartIsEmpty());
	
	
	}	
	
}

