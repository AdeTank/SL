package hMenuTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


public class HMenuLogoutTest extends BaseTest  {
/** user is logged in with standard_user & on <Inventory page>			
 */		
	
	@BeforeClass
	public void Precondition() {
		
		login.logIN("standard_user", "secret_sauce");
		Assert.assertTrue(inventory.getCurrentUrl());

}
/**
* Click <Logout> link 
* verify that user is on <Login Page>
 */
				
		@Test(priority = 1)
		public void hMenuLogout() {
						
			// From Hamburger menu select logout
				hMenu.clickLogoutFromHMenu();
					
				Assert.assertTrue(login.getCurrentUrl());
				
	}
	
	
}
