package inventoryTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;


	public class InventoryAddRemItemBtnTest extends BaseTest  {
		
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
* Add and remove item with <Add to cart> and <Remove> button
*/
		
	@Test(priority = 1, groups = {"positive"})
	public void addRemoveItemsBtn() throws Exception {
		
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsBikeLight, priceSauceLabsBikeLight));	
							
		//	Add item, assert that cart displays 1
		
		inventory.clickAddToCartBtn(itemSauceLabsBikeLight);
						
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		//	remove item, check that cart is empty
	
		inventory.clickRemoveBtn(itemSauceLabsBikeLight);

		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
	}
/**
* Add all items with <Add to cart> button
* verify that cart displays 6
* remove all items with <Remove> button
* verify that cart is empty
*/
	
	@Test(priority = 2, groups = {"positive"})
	public void addAllItemsAndRemoveThem() throws Exception {
	
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsBackpack, priceSauceLabsBackpack));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsBikeLight, priceSauceLabsBikeLight));		
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsBoltTShirt, priceSauceLabsBoltTShirt));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsFleeceJacket, priceSauceLabsFleeceJacket));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsOnesie, priceSauceLabsOnesie));
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemTestallTheThingsTShirtRed, priceTestallTheThingsTShirtRed));
				
		// add all items with <Add to cart> button
		inventory.addAllItems();
		
				//or add one by one 				
					/* //method 1
				  	inventory.clickAddToCartBtn(itemSauceLabsBackpack);
				  	inventory.clickAddToCartBtn(itemSauceLabsBikeLight);
				  	inventory.clickAddToCartBtn(itemSauceLabsBoltTShirt);
				  	inventory.clickAddToCartBtn(itemSauceLabsFleeceJacket);
				  	inventory.clickAddToCartBtn(itemSauceLabsOnesie);
				  	inventory.clickAddToCartBtn(itemTestallTheThingsTShirtRed);
				  	*/
		
				  	/* //method 2
					inventory.clickAddToCartBtnSauceLabsBackpack();
					inventory.clickAddToCartBtnSauceLabsBikeLight();	
					inventory.clickAddToCartBtnSauceLabsBoltTShirt();	
					inventory.clickAddToCartBtnSauceLabsFleeceJacket();	
					inventory.clickAddToCartBtnSauceLabsOnesie();	
					inventory.clickAddToCartBtnTestallTheThingsTShirtRed();	
					*/
				
		Assert.assertEquals(carti.cartCounter(), "6", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
		// remove all items with <Remove> button
		inventory.removeAllItems();
		
				//or remove them one by one 
					/* //method 1
					inventory.clickRemoveBtn(itemSauceLabsBackpack);
				  	inventory.clickRemoveBtn(itemSauceLabsBikeLight);
				  	inventory.clickRemoveBtn(itemSauceLabsBoltTShirt);
				  	inventory.clickRemoveBtn(itemSauceLabsFleeceJacket);
				  	inventory.clickRemoveBtn(itemSauceLabsOnesie);
				  	inventory.clickRemoveBtn(itemTestallTheThingsTShirtRed);
				  	*/
		
					/* //method 2
					inventory.clickRemoveBtnSauceLabsBackpack();
					inventory.clickRemoveBtnSauceLabsBikeLight();
					inventory.clickRemoveBtnSauceLabsBoltTShirt();
					inventory.clickRemoveBtnSauceLabsFleeceJacket();
					inventory.clickRemoveBtnSauceLabsOnesie();
					inventory.clickRemoveBtnTestallTheThingsTShirtRed();
					*/
							
		Assert.assertTrue(carti.checkIfCartIsEmpty());
		
	}	
	/**
	* Add/Remove item combination of all 3 methods
	* verify item name and price
	* click <Add to cart> button and assert that cart displays 1
	* click Item Image
	* verify that items is displayed on <Inventory Items Page>
	* remove item from <Inventory Items Page> and verify that cart is empty
	* click back button on <Inventory Items Page>
	* click item name from <Inventory Page>
	* verify that items is displayed on <Inventory Items Page>
	* click <Add to cart> button
	* click back button on <Inventory Items Page>
	* click <Remove> button from <Inventory Page>
	* verify that cart is empty
	*/	
	
	@Test(priority = 3, groups = {"positive"})
	public void addRemoveCombination() throws Exception {
		
		Assert.assertTrue(inventory.verifyItemNameAndPrice(itemSauceLabsBikeLight, priceSauceLabsBikeLight));	
							
			inventory.clickAddToCartBtn(itemSauceLabsBikeLight);
			
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
			inventory.clickItemImg(itemSauceLabsBikeLight);
						
		Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemSauceLabsBikeLight, priceSauceLabsBikeLight));	
			
			itemsPage.clickRemoveBtn();
			
		Assert.assertTrue(carti.checkIfCartIsEmpty());
			
			itemsPage.clickBackBtn();
			
			inventory.clickItemName(itemSauceLabsBikeLight);
			
		Assert.assertTrue(itemsPage.verifyItemNameAndPrice(itemSauceLabsBikeLight, priceSauceLabsBikeLight));	
			
			itemsPage.clickAddToCartBtn();
			
		Assert.assertEquals(carti.cartCounter(), "1", "Cart is not showing correct number of items");
		System.out.println("Number of items in the cart: " + carti.cartCounter());
		
			itemsPage.clickBackBtn();
			
		  	inventory.clickRemoveBtn(itemSauceLabsBikeLight);
			
		Assert.assertTrue(carti.checkIfCartIsEmpty());
			
	}	
			
}
