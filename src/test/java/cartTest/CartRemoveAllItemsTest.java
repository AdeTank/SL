package cartTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


public class CartRemoveAllItemsTest extends BaseTest  {
	
	
	@BeforeClass

	public void Precondition() {
/**
 * Precondition: User is logged in
 * <Inventory page> all items are added 
 */
		
		login.logIN("standard_user", "secret_sauce");
				
		inventory.addAllItems();
		Assert.assertEquals(carti.cartCounter(), "6", "Cart is not showing correct number of items");
			
		carti.clickCartBtn();
		
	}
/**
* Remove all items displayed on the <Cart Page>
*/
		@Test(priority = 1, groups = {"positive"})
		public void removeAllItemsFromCart() {
		
			Assert.assertTrue(cart.getCurrentUrl());
			
			Assert.assertEquals(carti.cartCounter(), "6", "Cart is not showing correct number of items");
			System.out.println("Number of items in the cart: " + carti.cartCounter());
			
			cart.removeAllItems();
			
			Assert.assertTrue(carti.checkIfCartIsEmpty());
				
	}	
		
}

