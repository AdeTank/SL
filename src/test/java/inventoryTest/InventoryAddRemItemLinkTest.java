package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


	public class InventoryAddRemItemLinkTest extends BaseTest  {
		
		private String itemId0 = "Sauce Labs Bike Light", price0 = "9.99";
				
	@BeforeClass
	public void Precondition() {
		
			login.logIN("standard_user", "secret_sauce");
			Assert.assertTrue(inventory.getCurrentUrl());
			
	}		
/**
 * There are 6 items on the page, and 3 ways you can add them to the cart  
 * 1 clickAddToCartBtn (button Add To Cart), 2 clickItemName (click on name link), 3 clickItemImg (click on image)
 * for methods 2 and 3 new page will open with another <Add To Cart> button
 */

/**
* verify item name & price
* click on the name/link of the item
* verify <Inventory Items Page> is open in the same tab
* verify item name & price is the same
* verify that status of the button is <Add to cart>
* click <Add to cart> button  
* click <Back> button,
* verify that user is on <Inventory Page> 
* verify that cart shows 1
*/
	
	@Test(priority = 1, groups = {"positive"})
	public void clickItemName() throws Exception {
			
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));	
				
	// click on item link
			inventory.clickItemName(itemId0);
					
	// verify that new page is open in the same tab
	// each item has its own <Items page> depending on the item id, for example „Sauce Labs Bike Light“ - id=0
			Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", 
					"User is not on new <Items pagec");
			
			Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId0, price0));			
					
	// From the <Inventory Page> to <Inventory Items page> default status of the button is "ADD TO CART"
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");	
		
	// click <ADD TO CART> button on new <Inventory Item page>
			itemsPage.clickAddToCartBtn();
		
	// verify that cart shows 1
			Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
			System.out.println("Number of items in the cart: " + carti.cartCounter());
				
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not shown");	
		
	// click back button on new <Inventory Item page>
			itemsPage.clickBackBtn();
		
	// verify that user is back on <Inventory Page>
			Assert.assertTrue(inventory.getCurrentUrl());
	
			Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
					
	}
/**
* verify item name & price on <Inventory page>
* click <Add to cart> button
* click on Item link
* verify new product page is open 
* verify item name & price is the same
* verify status of the button is <Remove>
* click <Remove> button
* verify that button now displays <Add to cart>
* click back button
* verify that user is back on <Inventory Page> 
* verify that cart is empty 
*/
	
		@Test(priority = 2, groups = {"positive"})
		public void addItemClickItemLinkRemoveItem() throws Exception {
			
			Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));	
			
			inventory.clickAddToCartBtn(itemId0);
			
			Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
					
			inventory.clickItemName(itemId0);
					
			Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", 
						"User is not on new <Items page>");
		
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not shown");	
	
			itemsPage.clickRemoveBtn();
				
			Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");	
				
			itemsPage.clickBackBtn();
				
			Assert.assertTrue(inventory.getCurrentUrl());
		
			Assert.assertTrue(carti.checkIfCartIsEmpty());
						
		}
	
}
