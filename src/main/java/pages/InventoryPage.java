package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class InventoryPage extends BasePage {
	
	//Locators************************************************************************************************
	private By subheader = By.className("title");
			
	//dropdown menu
	private By dropdownMenu = By.className("product_sort_container");
	
	//for No. & names of items
	private By allItems = By.className("inventory_item_name");
	
	//add items
	private By clickAddToCartAllItems = By.xpath("//button[contains(., 'Add to cart')]");
	private By clickRemoveAllItems = By.xpath("//button[contains(., 'Remove')]");
	
	public String clickItemImg = "//div[@class='inventory_item_name'][contains(text(),'%s')]/preceding:: img[@class='inventory_item_img'][1]";
	public String clickItemName = "//div[@class='inventory_item_name'][contains(text(),'%s')]";

	
	// method 2
	//Sauce Labs Backpack
	private By clickAddToCartBtnSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
	private By itemNameSauceLabsBackpack = By.id("item_4_title_link");
	private By clickRemoveBtnSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
	
	//Sauce Labs Bike Light
	private By clickAddToCartBtnSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	private By itemNameSauceLabsBikeLight = By.id("item_0_title_link");
	private By clickRemoveBtnSauceLabsBikeLight = By.id("remove-sauce-labs-bike-light");
	
	//Sauce Labs Bolt T-Shirt
	private By clickAddToCartBtnSauceLabsBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	private By itemNameSauceLabsBoltTShirt = By.id("item_1_title_link");
	private By clickRemoveBtnSauceLabsBoltTShirt = By.id("remove-sauce-labs-bolt-t-shirt");
	
	//Sauce Labs Fleece Jacket
	private By clickAddToCartBtnSauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By itemNameSauceLabsFleeceJacket = By.id("item_5_title_link");
	private By clickRemoveBtnSauceLabsFleeceJacket = By.id("remove-sauce-labs-fleece-jacket");
	
	//Sauce Labs Onesie
	private By clickAddToCartBtnSauceLabsOnesie = By.id("add-to-cart-sauce-labs-onesie");
	private By itemNameSauceLabsOnesie = By.id("item_2_title_link");
	private By clickRemoveBtnSauceLabsOnesie = By.id("remove-sauce-labs-onesie");
	
	//Test.allTheThings() T-Shirt (Red)
	private By clickAddToCartBtnTestallTheThingsTShirtRed = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	private By itemNameTestallTheThingsTShirtRed = By.id("item_3_title_link");
	private By clickRemoveBtnTestallTheThingsTShirtRed = By.id("remove-test.allthethings()-t-shirt-(red)");
	
	
	//*******************************************************************************************************
	public InventoryPage(WebDriver driver) {
	      super(driver);
	       
	}  
	
		public boolean getCurrentUrl() {
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "User is not on <Inventory page>");
			return true;
			
	}	
		public void goToInventoryPage() {
	        driver.get("https://www.saucedemo.com/inventory.html");
	       
	}
		
		public String subheader() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(subheader)).getText();
			
	}
		
		public void clickItemImg(String itemName) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(clickItemImg, itemName)))).click();
			System.out.println("Item image: " + itemName);
			 
	}	
		
		public void clickItemName(String itemName) throws Exception {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(clickItemName, itemName)))).click();
				System.out.println("Item name: " + itemName);
			
	}	
	
	// check the No of items on the <Inventory Page>
		public int getNumberOfItems() {
			List<WebElement> allItemsNo = driver.findElements(allItems);
			System.out.println("Number of the items on the page: " + allItemsNo.size());
			return allItemsNo.size();
	
	}
		// print names of items	
		public void getItemsNameLinks() {
			List<WebElement> getItemsNameLinks = driver.findElements(allItems);
			for (WebElement webElement: getItemsNameLinks) {
				String name = webElement.getText();
				System.out.println("Item name: " + name);
			}
			
	}			
		
		public boolean verifyItemNameAndPrice(String itemName, String itemPrice) throws Exception {
			try {
					 driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]"
						 		+ "/following:: div[@class='inventory_item_price'][contains(.,\"" + itemPrice + "\")][1]"));
					 System.out.println(itemName + ", $" + itemPrice + " - is listed on <Inventory page>");
			            return true;
			        } catch (NoSuchElementException e) {
			        //	e.printStackTrace();
			        	System.out.println(itemName + ", $" + itemPrice + " - is not listed on the <Inventory page>");
			            return false;
			    }
				 
	}		
				
		public String getDropdownMenu() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenu)).getText();
			
	}
		
		public void dropdown(String dropDown) {
			
			Select select = new Select(driver.findElement(dropdownMenu));
		    select.selectByVisibleText(dropDown); 
			
			
	}
			
// Add all items that have <Add to cart> button
		public void addAllItems() {
			List<WebElement> addAllItems = driver.findElements(clickAddToCartAllItems);
		    for (WebElement clickAddToCartBtn: addAllItems ) { 
		       	clickAddToCartBtn.click();  
		    }
			    
	}
		
// Add all items that have <Remove> button
		public void removeAllItems() {
			List<WebElement> removeAllItems = driver.findElements(clickRemoveAllItems);
		    for (WebElement clickRemoveBtn: removeAllItems ) { 
		    	clickRemoveBtn.click();  
			}
		
	}
		
// method 1	
		public void clickAddToCartBtn(String itemName) throws Exception {
					WebElement button = driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]/following:: button")); 
					String text = button.getText(); 
					if (text.contains("ADD TO CART")) {
					button.click();
					}
					WebElement remove = driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]/following:: button")); 
						String text1 = remove.getText(); 
						if (text1.contains("REMOVE")) {
							System.out.println("Item added from the <Inventory Page>: " + itemName);
						}	
						else {
						if (text1.contains("ADD TO CART")) {
						System.out.println("Item not added: " + itemName);
					}
						}
					
	}     
				
// method 1			
		public void clickRemoveBtn(String itemName) throws Exception {
					WebElement button = driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]/following:: button")); 
					String text = button.getText(); 
					if (text.contains("REMOVE")) {
					button.click();
					}
					WebElement remove = driver.findElement(By.xpath("//div[contains(.,\"" + itemName + "\")]/following:: button")); 
						String text1 = remove.getText(); 
						if (text1.contains("ADD TO CART")) {
							System.out.println("Item removed from the <Inventory Page>: " + itemName);
						}	
											else {
												if (text1.contains("REMOVE")) {
													System.out.println("Item not removed: " + itemName);
						}
					}
						
	}	
				
// method 2
		public void clickAddToCartBtnSauceLabsBackpack() {
			driver.findElement(clickAddToCartBtnSauceLabsBackpack).click();
			String itemName = driver.findElement(itemNameSauceLabsBackpack).getText();
			System.out.println("Item added to cart: " + itemName);
			
		}
		
		public void clickRemoveBtnSauceLabsBackpack() {
			driver.findElement(clickRemoveBtnSauceLabsBackpack).click();
			String itemName = driver.findElement(itemNameSauceLabsBackpack).getText();
			System.out.println("Item removed from the cart: " + itemName);
				
		}
		
		public void clickAddToCartBtnSauceLabsBikeLight() {
			driver.findElement(clickAddToCartBtnSauceLabsBikeLight).click();
			String itemName = driver.findElement(itemNameSauceLabsBikeLight).getText();
			System.out.println("Item added to cart: " + itemName);
			
		}

		public void clickRemoveBtnSauceLabsBikeLight() {
			driver.findElement(clickRemoveBtnSauceLabsBikeLight).click();
			String itemName = driver.findElement(itemNameSauceLabsBikeLight).getText();
			System.out.println("Item removed from the cart: " + itemName);
			
		}

		public void clickAddToCartBtnSauceLabsBoltTShirt() {
			driver.findElement(clickAddToCartBtnSauceLabsBoltTShirt).click();
			String itemName = driver.findElement(itemNameSauceLabsBoltTShirt).getText();
			System.out.println("Item added to cart: " + itemName);
			
		}
		
		public void clickRemoveBtnSauceLabsBoltTShirt() {
			driver.findElement(clickRemoveBtnSauceLabsBoltTShirt).click();
			String itemName = driver.findElement(itemNameSauceLabsBoltTShirt).getText();
			System.out.println("Item removed from the cart: " + itemName);
			
		}

		public void clickAddToCartBtnSauceLabsFleeceJacket() {
			driver.findElement(clickAddToCartBtnSauceLabsFleeceJacket).click();
			String itemName = driver.findElement(itemNameSauceLabsFleeceJacket).getText();
			System.out.println("Item added to cart: " + itemName);
			
		}
		
		public void clickRemoveBtnSauceLabsFleeceJacket() {
			driver.findElement(clickRemoveBtnSauceLabsFleeceJacket).click();
			String itemName = driver.findElement(itemNameSauceLabsFleeceJacket).getText();
			System.out.println("Item removed from the cart: " + itemName);
			
		}

		public void clickAddToCartBtnSauceLabsOnesie() {
			driver.findElement(clickAddToCartBtnSauceLabsOnesie).click();
			String itemName = driver.findElement(itemNameSauceLabsOnesie).getText();
			System.out.println("Item added to cart: " + itemName);
			
		}
		
		public void clickRemoveBtnSauceLabsOnesie() {
			driver.findElement(clickRemoveBtnSauceLabsOnesie).click();
			String itemName = driver.findElement(itemNameSauceLabsOnesie).getText();
			System.out.println("Item removed from the cart: " + itemName);
			
		}

		public void clickAddToCartBtnTestallTheThingsTShirtRed() {
			driver.findElement(clickAddToCartBtnTestallTheThingsTShirtRed).click();
			String itemName = driver.findElement(itemNameTestallTheThingsTShirtRed).getText();
			System.out.println("Item added to cart: " + itemName);
			
		}

		public void clickRemoveBtnTestallTheThingsTShirtRed() {
			driver.findElement(clickRemoveBtnTestallTheThingsTShirtRed).click();
			String itemName = driver.findElement(itemNameTestallTheThingsTShirtRed).getText();
			System.out.println("Item removed from the cart: " + itemName);
			
		}

		
}