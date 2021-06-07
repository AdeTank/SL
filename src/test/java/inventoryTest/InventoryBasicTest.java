package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class InventoryBasicTest extends BaseTest  {
		
	
	@BeforeClass
	public void Precondition() {
	
		login.logIN("standard_user", "secret_sauce");
		
	}	
		
/**
* verify url
* verify header 
* verify that there are 6 items on the page & print their names
* verify items name and price 
* @throws Exception 
*/

		@Test(priority = 1, groups = {"positive"})

		public void inventoryTestBasic() throws Exception {
					
			Assert.assertTrue(inventory.getCurrentUrl());
			
		// Header text - <PRODUCTS>	
			Assert.assertEquals(inventory.subheader(), "PRODUCTS", "Products is not displayed");
			System.out.println("Subheader: " + inventory.subheader());
						
		// check the No of items on the <Inventory Page>
			Assert.assertEquals(inventory.getNumberOfItems(), 6, "Number of items is not 6");	
				
		// print names of items		
			inventory.getItemsNameLinks();
						
		// verify item name and price 	
			Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Backpack", "29.99"));	
			Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Bike Light", "9.99"));	
			Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Bolt T-Shirt", "15.99"));	
			Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Fleece Jacket", "49.99"));	
			Assert.assertTrue(inventory.verifyItemNameAndPrice("Sauce Labs Onesie", "7.99"));	
			Assert.assertTrue(inventory.verifyItemNameAndPrice("Test.allTheThings() T-Shirt (Red)", "15.99"));	
		
	}		
		
		
}