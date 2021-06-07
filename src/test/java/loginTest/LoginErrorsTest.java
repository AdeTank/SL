package loginTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest; 

/**
* check *4 error messages with login & take a screenshot
*/	

	public class LoginErrorsTest extends BaseTest  {

/**
* Error: Epic sadface: Username is required
* take a screenshot 1
*/
	
// confirm that the user cannot log in when username and password are missing
	@Test(priority = 1, groups = {"negative"})
		public void loginWithNoUsernameAndPassword() throws Exception {
		
			login.logIN("", "");
	
		Assert.assertEquals(login.errorText(), "Epic sadface: Username is required");
		System.out.println("Error message with: no username + no password = " + login.errorText());
		
		screenshot("Epic_sadface_Username_is_required");
		
	}
	
// confirm that the user cannot log in without a username and a valid password
	@Test(priority = 2, groups = {"negative"})
		public void loginNoUsernameAndWithValidPassword() throws Exception {
		
			login.logIN("", "secret_sauce");
	
		Assert.assertEquals(login.errorText(), "Epic sadface: Username is required");
		System.out.println("Error message with: no username + valid password = " + login.errorText());
		
	}
	
// confirm that the user cannot log in without username and random password  
		@Test(priority = 3, groups = {"negative"})
		public void loginNoUsernameAndWithRandomPassword() throws Exception {
			
			login.logIN("", "randomPass");
			
		Assert.assertEquals(login.errorText(), "Epic sadface: Username is required");
		System.out.println("Error message with: no username + random password = " + login.errorText());
			
	}
/**
* Error: Epic sadface: Password is required
* take a screenshot 2
*/
		
// confirm that the user cannot log in with valid username and missing password 
		@Test(priority = 4, groups = {"negative"})
		public void loginUsernameAndNoPassword() throws Exception {
		
			login.logIN("standard_user", "");
				
		Assert.assertEquals(login.errorText(), "Epic sadface: Password is required");
		System.out.println("Error message with: valid username + no password = " + login.errorText());
		
		screenshot("Epic_sadface_Password_is_required");
		
	}	
		
// confirm that the user cannot log in with random username and missing password 
		@Test(priority = 5, groups = {"negative"})
		public void loginRandomUsernameAndNoPassword() throws Exception {
			
			login.logIN("randomUsername", "");
	
		Assert.assertEquals(login.errorText(), "Epic sadface: Password is required");
		System.out.println("Error message with: random username + no password = " + login.errorText());
				
	}
/**
* Error: Epic sadface: Sorry, this user has been locked out
* take a screenshot 3
*/
// confirm that the user cannot log in with locked_out_user username and valid password 
		@Test(priority = 6, groups = {"negative"})
		public void loginLockedOutUserAndValidPassword() throws Exception {
			
			login.logIN("locked_out_user", "secret_sauce");
	
		Assert.assertEquals(login.errorText(), "Epic sadface: Sorry, this user has been locked out.");
		System.out.println("Error message with: locked_out_user + valid password = " + login.errorText());
		
		screenshot("Epic_sadface_Sorry_this_user_has_been_locked_out");
		
	}
/**
* Error: Epic sadface: Username and password do not match any user in this service
* take a screenshot 4
*/
// confirm that the user cannot log in with Accepted usernames and random password 
		@Test(priority = 7, groups = {"negative"})
		public void loginUsernameRandomPassword() throws Exception {
			
			login.logIN("standard_user", "randomPassword");
		
		Assert.assertEquals(login.errorText(), "Epic sadface: Username and password do not match any user in this service");
		System.out.println("Error message with: valid username + random password = " + login.errorText());
						
		screenshot("Epic_sadface_Username_and_password_do_not_match_any_user_in_this_service");
		
	}
// confirm that the user cannot log in with random username and valid password
		@Test(priority = 8, groups = {"negative"})
		public void loginRandomUserAndValidPassword() throws Exception {
			
			login.logIN("randomUsername", "secret_sauce");		
			
		Assert.assertEquals(login.errorText(), "Epic sadface: Username and password do not match any user in this service");
		System.out.println("Error message with: random username + valid password = " + login.errorText());
		
	}		
		
		@Test(priority = 9, description = "Click Login button, after error message is displayed click X button to close it")
		public void clickErrorBtn() throws Exception {
		
			login.logIN("", "");		
					
		Assert.assertEquals(login.errorText(), "Epic sadface: Username is required");
	
			login.clickErrorBtn();	
				
	}
				
	@AfterMethod
	public void Refresh() {
					
		refresh(); 
	
	}

}

