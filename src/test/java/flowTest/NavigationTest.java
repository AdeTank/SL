package flowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest; 

public class NavigationTest extends BaseTest  {
	
	
	@Test(priority = 1)
	public void navigationFromPageToPageAndBackTest() throws Exception {
		
		login.logIN("standard_user", "secret_sauce");
			
		Assert.assertTrue(inventory.getCurrentUrl());

		carti.clickCartBtn();
		Assert.assertTrue(cart.getCurrentUrl());
	cart.clickContinueShoppingBtn(); // back to <Inventory page>

		Assert.assertTrue(inventory.getCurrentUrl());
		
		carti.clickCartBtn();
		Assert.assertTrue(cart.getCurrentUrl());
		cart.clickCheckoutBtn();
	
		Assert.assertTrue(checkout1.getCurrentUrl());	
	checkout1.clickCancelBtn(); // back to <Cart page>
	
		Assert.assertTrue(cart.getCurrentUrl());
		cart.clickCheckoutBtn();
	
		Assert.assertTrue(checkout1.getCurrentUrl());	
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");

		Assert.assertTrue(checkout2.getCurrentUrl());	
	checkout2.clickCancelBtn(); // back to <Inventory page>
		
		Assert.assertTrue(inventory.getCurrentUrl());
		
		carti.clickCartBtn();
		Assert.assertTrue(cart.getCurrentUrl());	
		cart.clickCheckoutBtn();
	
		Assert.assertTrue(checkout1.getCurrentUrl());	
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");

		Assert.assertTrue(checkout2.getCurrentUrl());	
		checkout2.clickFinishBtn();

		Assert.assertTrue(checkout3.getCurrentUrl());	
		
		carti.clickCartBtn();
		Assert.assertTrue(cart.getCurrentUrl());
		
		hMenu.clickAllItemsFromHMenu(); // back to <Inventory page>
		
		Assert.assertTrue(inventory.getCurrentUrl());
		
		hMenu.clickLogoutFromHMenu(); // back to <Login page>
		
		login.getCurrentUrl();
		login.getTitle();
	
		
	}

}