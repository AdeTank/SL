package hMenuTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


	public class HMenuAllItemsTest extends BaseTest  {
		
	@BeforeClass
	public void Precondition() {
	
			login.logIN("standard_user", "secret_sauce");
			Assert.assertTrue(inventory.getCurrentUrl());	
			
		}
/**
* Click <All Items> link, 
* after page reloads, 
* verify that user is still on <Inventory page>	
*/		
		@Test(priority = 1, groups = {"positive"})
		public void clickHMenuAllItmes() {
												
			hMenu.clickAllItemsFromHMenu();
			hMenu.clickCloseHMenu();
							
			Assert.assertTrue(inventory.getCurrentUrl());
						
		}
/**
* Click cart button, 
* from <Cart Page> click h Menu, 
* select <All Items> link, 
* verify that user is on <Inventory page>	
*/		
		
		@Test(priority = 2, groups = {"positive"})
		public void fromCartPageClickAllItemsFromHMenu() {
			
			carti.clickCartBtn();
			Assert.assertTrue(cart.getCurrentUrl());
						
			hMenu.clickAllItemsFromHMenu();
				
			Assert.assertTrue(inventory.getCurrentUrl());
			
	}	
		
}
