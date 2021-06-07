package loginTest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import base.BaseTest; 


/**
* Login with accepted usernames (standard_user, problem_user, performance_glitch_user) and a valid password for all users (secret_sauce)
* (displayed on the Swag Labs website) 
* @AfterMethod check that user is on the <Inventory page> after login, and after logging out from H menu, that user is back on the <Login page>
*/	

	public class LoginAndLogoutTest extends BaseTest  {
				
		@Test(priority = 1, groups = {"positive"}) 
		public void loginWithStandardUser() throws Exception {
			
			login.logIN("standard_user", "secret_sauce");
				
	}	
		
		@Test(priority = 2, groups = {"positive"})
		public void loginWithProblemUser() throws Exception {
			
			login.logIN("problem_user", "secret_sauce");		
							
	}
				
		@Test(priority = 3, groups = {"positive"})
		public void loginWithPerformanceGlitchUser() throws Exception {
			
			login.logIN("performance_glitch_user", "secret_sauce");		
							
	}

	@AfterMethod
	public void logout() {
	
			Assert.assertTrue(inventory.getCurrentUrl());
						
			hMenu.clickLogoutFromHMenu();
			
			Assert.assertTrue(login.getCurrentUrl());
			

	}

	
}
