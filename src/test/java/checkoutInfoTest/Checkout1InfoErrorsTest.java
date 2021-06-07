package checkoutInfoTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class Checkout1InfoErrorsTest extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack";

	
	@BeforeClass
	public void Precondition() throws Exception {
/**
* Precondition: User is logged in <Login page>, item is added <Inventory page>, from <Cart page> click on <Checkout> button
*                                               Note: test can be run with no items added 
*/		
		
			login.logIN("standard_user", "secret_sauce");
			
			inventory.clickAddToCartBtn(itemId4);
					
			carti.clickCartBtn();
			cart.clickCheckoutBtn();
			
			Assert.assertTrue(checkout1.getCurrentUrl());
				
	}
	/**
	 * click <Continue> button 
	 * verify error "Error: First Name is required"
	 * take a screenshot
	 */

		@Test(priority = 1, groups = {"negative"})
		public void checkoutWithNoInfo() throws Exception {
						
			checkout1.checkoutYourInfo("", "", "");
						
			Assert.assertEquals(checkout1.errorText(), "Error: First Name is required");
			System.out.println("Error message in Checkout process > missing all info: " + checkout1.errorText());
			
			screenshot("Error_First_Name_is_required");
				
	}
		/**
		 * enter first name and click <Continue> button 
		 * verify error "Error: Last Name is required"
		 * take a screenshot
		 */

		@Test(priority = 2, groups = {"negative"})
		public void checkoutOnlyFirstName() throws Exception {
										
			checkout1.checkoutYourInfo("Test", "", "");
	
			Assert.assertEquals(checkout1.errorText(), "Error: Last Name is required");
			System.out.println("Error message in Checkout process > enter only First name: " + checkout1.errorText());
			
			screenshot("Error_Last_Name_is_required");
						
	}
		/**
		 * enter first & last name and click <Continue> button 
		 * verify error "Error: Postal Code is required"
		 * take a screenshot
		 */

		@Test(priority = 3, groups = {"negative"})
		public void checkoutWithoutPostalCode() throws Exception {
			
			checkout1.checkoutYourInfo("Test", "Labs", "");
				
			Assert.assertEquals(checkout1.errorText(), "Error: Postal Code is required");
			System.out.println("Error message in Checkout process > no postal code  = " + checkout1.errorText());
			
			screenshot("Error Postal Code is required");
				
	}
		
	@AfterMethod
	public void Refresh() {
		
		refresh(); 
		
	}

}
