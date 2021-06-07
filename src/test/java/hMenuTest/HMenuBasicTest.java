package hMenuTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import base.BaseTest;


	
	public class HMenuBasicTest extends BaseTest  { 
						
		@BeforeClass
		public void Precondition() {
/** user is logged in with standard_user & on <Inventory page>			*/	
			
			login.logIN("standard_user", "secret_sauce");
			Assert.assertTrue(inventory.getCurrentUrl());
		
	}		
		/**
		* get value from hamburger menu 
		* click <Close Menu> X button 
		*/
		
		@Test(priority = 1, groups = {"positive"})
		public void openAndCloseHMenu() {
		
				hMenu.clickHMenuBtn();
							
				// get value from H Menu 
				Assert.assertEquals(hMenu.getHMenuLinks(), "ALL ITEMS\n" + 
						"ABOUT\n" + 
						"LOGOUT\n" + 
						"RESET APP STATE", "The values in the menu list do not match");
			
				System.out.println("Menu links: " + hMenu.getHMenuLinks());
				
				// From Hamburger menu select X - Close Menu
				hMenu.clickCloseHMenu();
			
		}	
		
	
}
	