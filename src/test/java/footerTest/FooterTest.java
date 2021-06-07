package footerTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import base.BaseTest;


	
	public class FooterTest extends BaseTest  { 
						
		@BeforeClass
		public void Precondition() {
/** 
 * user is logged in with standard_user		
 * */	
			
			login.logIN("standard_user", "secret_sauce");
			Assert.assertTrue(inventory.getCurrentUrl());
		
	}		
		/**
		* click <Twitter> in footer
		* verify that SauceLabs Twitter page is open
		* close the new window and return to SwagLabs Page
		*/
		
		@Test(priority = 1, groups = {"positive"})
		public void clickTwitter() {
		
				footer.clickTwitter();
				
				footer.verifySaucelabsTwitterPageIsOpen();
						
				
		}	
		
		/**
		* click <Facebook> in footer
		* verify that SauceLabs Facebook page is open
		* close the new window and return to SwagLabs Page
		*/
		
		@Test(priority = 2, groups = {"positive"})
		public void clickFacebook() {
		
				footer.clickFacebook();
				
				footer.verifySaucelabsFacebookPageIsOpen();
					
		}	
		
		
		/**
		* click <Linkedin> in footer
		* verify that SauceLabs Linkedin page is open
		* close the new window and return to SwagLabs Page
		*/
		
		@Test(priority = 3, groups = {"positive"})
		public void clickLinkedin() {
		
				footer.clickLinkedin();
				
				footer.verifySaucelabsLinkedinPageIsOpen();
						
				
		}	
}
	