package flowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest; 

public class DetailedTest extends BaseTest  {
	
	private String itemId4 = "Sauce Labs Backpack", price4 = "29.99";
	private String itemId0 = "Sauce Labs Bike Light", price0 = "9.99";
	private String itemId1 = "Sauce Labs Bolt T-Shirt", price1 = "15.99";
	private String itemId5 = "Sauce Labs Fleece Jacket", price5 = "49.99";
	private String itemId2 = "Sauce Labs Onesie", price2 = "7.99";
	private String itemId3 = "Test.allTheThings() T-Shirt (Red)", price3 = "15.99";
	
	@Test(priority = 1)
	public void detailedComplete() throws Exception {
		
		login.logIN("standard_user", "secret_sauce");
			
		Assert.assertTrue(inventory.getCurrentUrl());
		Assert.assertEquals(inventory.subheader(), "PRODUCTS");
		System.out.println("Subheader: " + inventory.subheader());
	
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
		// check the No of items on the <Inventory Page>
		Assert.assertEquals(inventory.getNumberOfItems(), 6, "Number of items is not 6");	
					
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId4, price4));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));		
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId1, price1));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId5, price5));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId2, price2));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId3, price3));
				
		inventory.clickAddToCartBtn(itemId4);
	 
	 	Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
				
		inventory.clickAddToCartBtn(itemId0);
		
		Assert.assertEquals(carti.cartCounter(), "2", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		inventory.clickRemoveBtn(itemId0);
		
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		inventory.clickItemImg(itemId0);
		
		// verify that <Inventory Items page> is open in the same tab
		// each item has its own page depending on the item id, for example „Sauce Labs Bike Light“ - id=0
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", "User is not on the <Items page>");
		
		itemsPage.verifyItemNameAndPrice(itemId0, price0);
		
		// From the <Inventory Page> to <Inventory Items page> default status of the button is "ADD TO CART"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");	
				
		// click add button 
		itemsPage.clickAddToCartBtn();
				
		// navigate back to previous page
		itemsPage.clickBackBtn();
					
		// verify that user is back on <Inventory Page>
		Assert.assertTrue(inventory.getCurrentUrl());
					
		Assert.assertEquals(carti.cartCounter(), "2", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		inventory.clickItemName(itemId1);		
		
		// verify that <Inventory Items page> is open in the same tab
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=1", "User is not on the <Items page>");
				
		itemsPage.verifyItemNameAndPrice(itemId1, price1);
				
		// From the <Inventory Page> to <Inventory Items page> default status of the button is "ADD TO CART"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");	
						
		// click add button 
		itemsPage.clickAddToCartBtn();
						
		// navigate back to previous page
		itemsPage.clickBackBtn();
							
		// verify that user is back on <Inventory Page>
		Assert.assertTrue(inventory.getCurrentUrl());
										
		Assert.assertEquals(carti.cartCounter(), "3", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
								
		inventory.clickAddToCartBtn(itemId5);	
				
		Assert.assertEquals(carti.cartCounter(), "4", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		inventory.clickItemName(itemId5);
						
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=5", "User is not on the <Items page>");
		
		itemsPage.verifyItemNameAndPrice(itemId5, price5);
		
		// if item is added on <Inventory Page>, on <Inventory Items page> default status of the button is "REMOVE"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not shown");	
				
		// click remove button 
		itemsPage.clickRemoveBtn();
				
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");	
				
		// navigate back to previous page
		itemsPage.clickBackBtn();
		
		Assert.assertTrue(inventory.getCurrentUrl());
				
		Assert.assertEquals(carti.cartCounter(), "3", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());						
	
		carti.clickCartBtn();
		
		Assert.assertTrue(cart.getCurrentUrl());
		Assert.assertEquals(cart.title(), "YOUR CART");
		System.out.println("Page Title: " + cart.title());
			
		Assert.assertEquals(carti.cartCounter(), "3", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());	
		
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId4, price4));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId0, price0));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemId1, price1));
			
		cart.clickRemoveBtn(itemId4);
		
		Assert.assertFalse(cart.verifyItemNameAndPrice(itemId4, price4));
		
		Assert.assertEquals(carti.cartCounter(), "2", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());	
		
		cart.clickItemName(itemId0);
		
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=0", "User is not on the <Items page>");
		
		itemsPage.verifyItemNameAndPrice(itemId0, price0);
		
		// From the <Cart Page> to <Inventory Items page> default status of the button is "REMOVE"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not shown");	
		
		itemsPage.clickRemoveBtn();
				
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");
				
		itemsPage.clickBackBtn();
		
		Assert.assertTrue(inventory.getCurrentUrl());
		
		carti.clickCartBtn();
		Assert.assertTrue(cart.getCurrentUrl());
						
		Assert.assertFalse(cart.verifyItemNameAndPrice(itemId0, price0));	
				
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		cart.clickContinueShoppingBtn();
		
		Assert.assertTrue(inventory.getCurrentUrl());
			
		inventory.clickAddToCartBtn(itemId5);
		
		Assert.assertEquals(carti.cartCounter(), "2", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());	
	
		carti.clickCartBtn();

		Assert.assertTrue(cart.getCurrentUrl());
		cart.clickCheckoutBtn();
				
		Assert.assertTrue(checkout1.getCurrentUrl());
		Assert.assertEquals(checkout1.subheader(), "CHECKOUT: YOUR INFORMATION");
		System.out.println("Subheader: " + checkout1.subheader());
				
		checkout1.clickCancelBtn(); // back to <Cart page>
		
		Assert.assertTrue(cart.getCurrentUrl());
		cart.clickCheckoutBtn();
		
		checkout1.checkoutYourInfo("Test", "Demo", "123456789");
		
		Assert.assertTrue(checkout2.getCurrentUrl());
		Assert.assertEquals(checkout2.subheader(), "CHECKOUT: OVERVIEW");
		System.out.println("Subheader: " + checkout2.subheader());	
		
		checkout2.clickItemName(itemId5);
		
		Assert.assertEquals(itemsPage.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=5", "User is not on the <Items page>");
				
		Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemId5, price5));		
		
		// From the <Checkout: Overview> page to <Inventory Items page> default status of the button is "REMOVE"
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not shown");	
					
		itemsPage.clickRemoveBtn();
				
		Assert.assertEquals(itemsPage.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not shown");
							
		itemsPage.clickBackBtn();
					
		Assert.assertTrue(inventory.getCurrentUrl());
				
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart before Reset App: " + carti.cartCounter());	
					
		hMenu.clickResetAppStateFromHMenu();
	
		refresh(); //  Note * after Reset App, a refresh is needed 
							
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
		inventory.addAllItems();
		
		Assert.assertEquals(carti.cartCounter(), "6", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());	
		
		carti.clickCartBtn();
	
		Assert.assertTrue(cart.verifyItemNameAndPrice(itemId4, price4));
		Assert.assertTrue(cart.verifyItemNameAndPrice(itemId0, price0));		
		Assert.assertTrue(cart.verifyItemNameAndPrice(itemId1, price1));
		Assert.assertTrue(cart.verifyItemNameAndPrice(itemId5, price5));
		Assert.assertTrue(cart.verifyItemNameAndPrice(itemId2, price2));
		Assert.assertTrue(cart.verifyItemNameAndPrice(itemId3, price3));
		
		cart.clickCheckoutBtn();
		
		Assert.assertTrue(checkout1.getCurrentUrl());
		checkout1.checkoutYourInfo("Test", "Demo", "123456789");
		
		Assert.assertTrue(checkout2.getCurrentUrl());
				
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId4, price4));
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId0, price0));		
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId1, price1));
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId5, price5));
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId2, price2));
		Assert.assertTrue(checkout2.verifyItemNameAndPrice(itemId3, price3));
		
		// verify that Item total value is $129.94
		Assert.assertEquals(checkout2.verifySubtotal(), 129.94, "Item total value is not correct");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
				
		Assert.assertEquals(checkout2.verifyTax(), 10.4, "Tax value is not correct");
		System.out.println("Tax: $" + checkout2.verifyTax());
								
		Assert.assertEquals(checkout2.verifyTotal(), 140.34, "Total value is not correct");
		System.out.println("Total: $" + checkout2.verifyTotal());
		
		checkout2.clickFinishBtn();
		
		Assert.assertTrue(checkout3.getCurrentUrl());
		Assert.assertEquals(checkout3.subheader(), "CHECKOUT: COMPLETE!");
		System.out.println("Subheader: " + checkout3.subheader());					
						
		Assert.assertEquals(checkout3.completeHeader(), "THANK YOU FOR YOUR ORDER");
		System.out.println("Checkout Complete message: " + checkout3.completeHeader());
							
		Assert.assertTrue(carti.checkIfCartIsEmpty());	
				
		hMenu.clickLogoutFromHMenu();
		
		login.getCurrentUrl();
		login.getTitle();
	
	}

}