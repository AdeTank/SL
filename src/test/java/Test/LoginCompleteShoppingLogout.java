package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import jdk.jfr.Description;
import pages.CartPage;
import pages.Checkout1Page;
import pages.Checkout2Page;
import pages.Checkout3Page;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginCompleteShoppingLogout extends BaseTest  {
	
	@Description("Login, add one item in the cart, complete shopping and log out")	
	@Test(priority = 1, groups = {"positive"}) 
	public void loginAddItemCompleteShoppingAndLogout() throws Exception {
		LoginPage login = getDriver();

		/**
		* Login with accepted username and a password (displayed on the Swag Labs website) 
		*/			
		
		
/**
 * Login page
 */
		
		// enter Username
		login.enterUsername("standard_user");
		
		// enter Password
		login.enterPassword("secret_sauce");
	
		// click the Login btn
		ProductsPage product = login.clickLoginBtn();
		
/**
* PRODUCTS page
*/				
		// Verify that user is on the <PRODUCTS> page
		Assert.assertTrue(product.getCurrentUrl());
		System.out.println("Page title - " + product.getTitle());
		Assert.assertEquals(product.getTitle(), "PRODUCTS", "User is not on the <PRODUCTS> page");
		
		// verify that the cart is empty
		Assert.assertFalse(product.cartNumber());
				
		// Verify product name and price
		Assert.assertTrue(product.verifyItemNameAndPrice("Sauce Labs Backpack", "$29.99"));
		
		Assert.assertEquals(product.verifyStatusOfBtn(), "ADD TO CART", "<ADD TO CART> button is not displayed");	
				
		// Click the <Add to cart> button for "Sauce Labs Backpack" product
		product.addToCartSauceLabsBackpack();
		
		Assert.assertEquals(product.verifyStatusOfBtn(), "REMOVE", "<REMOVE> button is not displayed");	
			
		// Check that number "1" is displayed for the cart icon	 
		Assert.assertEquals(product.cartCounter(), "1", "Cart is not showing correct number of items");
				
		// click on the Cart icon
		CartPage cart = product.clickCartBtn();			
	
/**
* YOUR CART page
*/
		
		// Verify that user is on the <YOUR CART> page
		Assert.assertTrue(cart.getCurrentUrl());
		System.out.println("Page title - " + cart.getTitle());
		Assert.assertEquals(cart.getTitle(), "YOUR CART", "User is not on the <YOUR CART> page");
								
		// Verify product name and price is displayed
		Assert.assertTrue(cart.verifyItemNameAndPrice("Sauce Labs Backpack", "$29.99"));	
							
		// click the Checkout btn
		Checkout1Page checkout1 = cart.clickCheckoutBtn();
			
/**
* CHECKOUT: YOUR INFORMATION page
*/			
		
		// Verify that user is on the <CHECKOUT: YOUR INFORMATION> page
		Assert.assertTrue(checkout1.getCurrentUrl());
		System.out.println("Page title - " + checkout1.getTitle());
		Assert.assertEquals(checkout1.getTitle(), "CHECKOUT: YOUR INFORMATION", "User is not on the <CHECKOUT: YOUR INFORMATION> page");		
				
		// enter First Name	
		checkout1.enterFirstName("Test");
				
		// enter Last Name	
		checkout1.enterLastName("User");
				
		// enter Zip/Postal Code	
		checkout1.enterZipCode("71000");
		
		// click the "Continue" btn
		Checkout2Page checkout2 = checkout1.clickContinueBtn();
		
/**
* CHECKOUT: OVERVIEW page
*/	
				
		// Verify that user is on the <CHECKOUT: OVERVIEW> page
		Assert.assertTrue(checkout2.getCurrentUrl());
		System.out.println("Page title - " + checkout2.getTitle());
		Assert.assertEquals(checkout2.getTitle(), "CHECKOUT: OVERVIEW", "User is not on the <CHECKOUT: OVERVIEW> page");	
										
		// Verify product name and price is displayed
		Assert.assertTrue(checkout2.verifyItemNameAndPrice("Sauce Labs Backpack", "$29.99"));
								
		// verify item total: $29.99, Tax: $2.40, Total: $32.39
		Assert.assertEquals(checkout2.verifySubtotal(), 29.99, "Item subtotal value is incorrect");
		System.out.println("Item total: $" + checkout2.verifySubtotal());
				
		Assert.assertEquals(checkout2.verifyTax(), 2.40, "Tax value is not correct");
		System.out.println("Tax: $" + checkout2.verifyTax());
				
		Assert.assertEquals(checkout2.verifyTotal(), 32.39, "Total value is not correct");
		System.out.println("Total: $" + checkout2.verifyTotal());
				
		// click the "Finish" btn
		Checkout3Page checkout3 = checkout2.clickFinishBtn();
								
/**
* CHECKOUT: COMPLETE! page
*/	
		
		// Verify that user is on the <CHECKOUT: YOUR INFORMATION> page
		Assert.assertTrue(checkout3.getCurrentUrl());
		System.out.println("Page title - " + checkout3.getTitle());
		Assert.assertEquals(checkout2.getTitle(), "CHECKOUT: COMPLETE!", "User is not on the <CHECKOUT: COMPLETE!> page");
				
		// verify success message
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkout3.successMessage());
		System.out.println(checkout3.successMessage());
		
		// verify that the cart is empty
		Assert.assertFalse(checkout3.cartNumber());
				
		// click Hmenu and Logout
		checkout3.clickHMenu();
		checkout3.clickLogoutLink();
	
/**
 * Login page
 */
		
		// Verify that user is on the <Login> page
		Assert.assertTrue(login.getCurrentUrl());
				
				
	}

}
