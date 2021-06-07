package loginTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest; 

/**
* try to navigate to pages without login and check error messages 
* Epic sadface: You can only access '/ .html' when you are logged in.
* & take a screenshot
*/	

	public class NavigationErrorsTest extends BaseTest  {
	
// confirm that the user cannot navigate to <Inventory Page> without login
		@Test(priority = 1, groups = {"negative"})
		public void withoutLoginTryInventoryUrl() throws Exception {
					
			inventory.goToInventoryPage();
			
		Assert.assertEquals(login.errorText(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");	
					
			screenshot("Epic_sadface_You_can_only_access_inventory_html_when_you_are_logged_in");
				
	}
		
// confirm that the user cannot go to <Cart Page> without logging in
		@Test(priority = 2, groups = {"negative"})
		public void withoutLoginTryCartUrl() throws Exception {
							
			cart.goToCartPage();
					
			Assert.assertEquals(login.errorText(), "Epic sadface: You can only access '/cart.html' when you are logged in.");	
							
			screenshot("Epic_sadface_You_can_only_access_cart_html_when_you_are_logged_in");
						
	}	
		
// confirm that the user cannot go to <Checkout: Your Information> without logging in
		@Test(priority = 3, groups = {"negative"})
		public void withoutLoginTryCheckoutOneUrl() throws Exception {
									
		checkout1.goToCheckout1Page();
							
		Assert.assertEquals(login.errorText(), "Epic sadface: You can only access '/checkout-step-one.html' when you are logged in.");	
									
		screenshot("Epic_sadface_You_can_only_access_checkout-step-one.html_when_you_are_logged_in");
								
	}	
// confirm that the user cannot go to <Checkout: Overview> without logging in
		@Test(priority = 4, groups = {"negative"})
		public void withoutLoginTryCheckoutTwoUrl() throws Exception {
											
			checkout2.goToCheckout2Page();
									
		Assert.assertEquals(login.errorText(), "Epic sadface: You can only access '/checkout-step-two.html' when you are logged in.");	
											
		screenshot("Epic_sadface_You_can_only_access_checkout-step-two.html_when_you_are_logged_in");
										
	}			
		
// confirm that the user cannot go to <Checkout: Complete> without logging in
		@Test(priority = 5, groups = {"negative"})
		public void withoutLoginTryCompleteUrl() throws Exception {
													
			checkout3.goToCheckout3Page();
											
			Assert.assertEquals(login.errorText(), "Epic sadface: You can only access '/checkout-complete.html' when you are logged in.");	
													
			screenshot("Epic_sadface_You_can_only_access_checkout-complete.html_when_you_are_logged_in");
												
	}		
					
	@AfterMethod
	public void Refresh() {
					
		refresh(); 
	
	}

}

