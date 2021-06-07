package hMenuTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


public class HMenuAboutTest extends BaseTest  {
	
	@BeforeClass

	public void Precondition() {
	
		login.logIN("standard_user", "secret_sauce");
		Assert.assertTrue(inventory.getCurrentUrl());
		
	}
/**
 * Click <About> link and verify new page is open
*/
						
	@Test(priority = 1, groups = {"positive"})
	public void clickHMenuAbout() throws Exception {
				
		// From Hamburger menu select <About> link
		hMenu.clickHMenuAbout();	
				
		// Verify Sauce Labs page is open
		Assert.assertEquals(hMenu.verifyNewSaucelabsPageIsOpen(), "https://saucelabs.com/", "User is not on <Saucelabs> page");
			
		// to get back to main page from <About> page
		back();
				
		// verify that the user is back on <Inventory Page>
		Assert.assertTrue(inventory.getCurrentUrl());
			
				
	}

}
