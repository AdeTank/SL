package checkoutInfoTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class Checkout2OverviewItemLinkTest extends BaseTest  {
	
	private String itemId2 = "Sauce Labs Onesie", price2 = "7.99";
		
	@BeforeClass
	public void Precondition() throws Exception {
/**
 * User is logged in and one item is added <Inventory page>, 
 * from <Cart page> click <Checkout> button, 
 * Complete Checkout1: Your Information and click on <Continue> button
 */
	
		login.logIN("standard_user", "secret_sauce");
		
		Assert.assertTrue(inventory.getCurrentUrl());
		inventory.clickAddToCartBtn(itemId2);
	
		carti.clickCartBtn();			
		cart.clickCheckoutBtn();	
		
		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Labs", "aa11AA");
		
	}
/**
 * Checkout2: Overview - Step two, 
 * verify item name, price, item total, tax & total
 * click on item
 * verify <Inventory Items Page> is open for that item
 * verify that default status of the button is <Remove>
 * remove item
 * verify that button now shows <Add to Cart>
 * click back button
 * verify that user is on <Inventory Page> and that cart is empty
 */

	@Test(priority = 1)
	public void clickItemNameAndRemoveItem() throws Exception {
					
		Assert.assertTrue(checkout2.getCurrentUrl());
		Assert.assertEquals(checkout2.subheader(), "CHECKOUT: OVERVIEW");
		System.out.println("Subheader: " + checkout2.subheader());	
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId2, price2));
		
		// verify that Item Total, Tax & Total
		Assert.assertEquals(checkout2.verifySubtotal(), 7.99, "Item total value is not right");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
		
		Assert.assertEquals(checkout2.verifyTax(), 0.64, "Tax value is not correct");
		System.out.println("Tax: $" + checkout2.verifyTax());
					
		Assert.assertEquals(checkout2.verifyTotal(), 8.63, "Total value is not correct");
		System.out.println("Total: $" + checkout2.verifyTotal());		
					
		checkout2.clickItemName(itemId2);

		// verify that new page is open in the same tab
		// each item has its own page depending on the item id,     for example „Sauce Labs Onesie“ - id=2
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=2", "User is not on right items page");
				
		// verify that on <Inventory Items page> name of the product is the same	
		Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId2, price2));
								
		// From the <Checkout: Overview> to <Inventory Items page> default status of the button is "REMOVE"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<Remove> button is not shown");		
					
		//Remove item from <Inventory Items page>
		itemsPage.clickRemoveBtn();
				
		// verify that button changes to "ADD TO CART"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");		
				
		// click back button
		itemsPage.clickBackBtn();	
		
		Assert.assertTrue(inventory.getCurrentUrl());

		Assert.assertTrue(carti.checkIfCartIsEmpty());
				
	}	
	
}
