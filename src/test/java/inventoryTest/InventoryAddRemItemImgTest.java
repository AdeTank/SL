package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


	public class InventoryAddRemItemImgTest extends BaseTest  {
		
		private String itemId0 = "Sauce Labs Bike Light", price0 = "9.99";
						
	@BeforeClass
	public void Precondition() {
		
			login.logIN("standard_user", "secret_sauce");
			Assert.assertTrue(inventory.getCurrentUrl());
			
	}		
/**
 * There are 6 items on the page, and 3 ways you can add them to the cart = 
 * 1 clickAddToCartBtn (button Add To Cart), 2 clickItemName (click on name link), 3 clickItemImg (click on image)
 * for methods 2 and 3 new page will open with another <Add To Cart> button
 */
			
/**
* verify that cart is empty
* verify item name & price
* click on the image of the item, 
* verify <Inventory Items Page> is open 
* verify status of the button
* click <Add to cart> button 
* verify that button now displays <Remove>
* click back button, 
* verify that user is on <Inventory Page> and that cart shows 1
*/
	
	@Test(priority = 1, groups = {"positive"})
	public void clickItemImage() throws Exception {
			
		// verify that cart is empty
		Assert.assertTrue(carti.checkIfCartIsEmpty());
			
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));	
						
		// click on image of the item 
		inventory.clickItemImg(itemId0);
		
		// verify that <Inventory Items page> is open in the same tab
		// each item has its own page depending on the item id, for example „Sauce Labs Bike Light“ - id=0
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", 
				"User is not on the <Items page>");
					
		// verify name and price of the item
		Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId0, price0));	
				
		// from the <Inventory Page> to <Inventory Items page> default status of the button is "ADD TO CART"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not displayed");	
	
		// click add button 
		itemsPage.clickAddToCartBtn();
		
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not displayed");	
			
		// click back button 
		itemsPage.clickBackBtn();
				
		// verify that user is back on <Inventory Page>
		Assert.assertTrue(inventory.getCurrentUrl());
					
		// verify that cart shows 1
		Assert.assertEquals(carti.cartCounter(), "1", "The cart does not display the exact number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());

	}
	
/**
* verify item name & price
* add item with <Add to cart> button
* verify that cart shows 1
* click on the image of the same product
* verify item name & price is the same
* verify status of the button is <Remove>
* remove item
* the button displays <Add to cart>
* return to <Inventory page>
* verify cart is empty
*/
				
	@Test(priority = 2, groups = {"positive"})
	public void addItemClickImageRemoveItem() throws Exception {
		
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));	
			
		inventory.clickAddToCartBtn(itemId0);
			
		Assert.assertEquals(carti.cartCounter(), "1", "The cart does not display the exact number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		inventory.clickItemImg(itemId0);
		
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", 
					"User is not on the right <Inventory Items page>");
		
		Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId0, price0));	
		
	// if an item has been added to <Inventory Page> with Add to Cart btn, on the <Inventory Items Page> the default button status is "REMOVE" 
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not displayed");	
		
		itemsPage.clickRemoveBtn();
		
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not displayed");	
	
		itemsPage.clickBackBtn();
				
		Assert.assertTrue(inventory.getCurrentUrl());
		
		Assert.assertTrue(carti.checkIfCartIsEmpty());
					
	
	}	
		
}
