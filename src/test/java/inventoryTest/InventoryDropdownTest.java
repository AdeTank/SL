package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

	public class InventoryDropdownTest extends BaseTest  {
	
		@BeforeClass

		public void Precondition() {
				
				login.logIN("standard_user", "secret_sauce");
				Assert.assertTrue(inventory.getCurrentUrl());
			
	}		
		
		@Test(priority = 1, groups = {"positive"})
		public void getValueFromDropdown() {
				
// get value from dropdown 
			Assert.assertEquals(inventory.getDropdownMenu(), "Name (A to Z)\n" + "Name (Z to A)\n" + "Price (low to high)\n" + 
							"Price (high to low)", "Value from dropdown list doesn't match ");
			System.out.println("Dropdown list: " + inventory.getDropdownMenu());
						
	}	
		
		@Test(priority = 2, groups = {"positive"})
		public void dropdownSelectNameAZ() {
			
			inventory.dropdown("Name (A to Z)");
			
			
	}	
		
		@Test(priority = 3, groups = {"positive"})
		public void dropdownSelectNameZA() {
				
			inventory.dropdown("Name (Z to A)");
			
				
	}	
		
		@Test(priority = 4, groups = {"positive"})
		public void dropdownSelectPriceLowToHigh() {
							
			inventory.dropdown("Price (low to high)");
			
		
	}	
		
		@Test(priority = 5, groups = {"positive"})
		public void dropdownSelectPriceHighToLow() {
		
			inventory.dropdown("Price (high to low)");
									
	}
/**
* AfterMethod: Refresh to default settings - Name (A - Z)
*/		
		@AfterMethod
		public void Refresh() {
					
		//	refresh(); 
		
	}
		
}