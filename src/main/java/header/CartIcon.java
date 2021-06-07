package header;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;


public class CartIcon extends BasePage {
		
	//Locators ************************************************************************************************ 
	private By clickCartBtn = By.id("shopping_cart_container");
	private By cartCounter = By.className("shopping_cart_badge");
		
	//Constructor ************************************************************************************************ 
		public CartIcon(WebDriver driver) {
			super(driver);
		
	}


		public boolean checkIfCartIsEmpty()  {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> cartCounter1  = driver.findElements(cartCounter);
			if(cartCounter1.size() != 0) {
				System.out.println("Cart is not empty");
			return false;
		} else {
			System.out.println("Cart is empty");
		}
		return true;
					
	}

		public String cartCounter() {
			return driver.findElement(cartCounter).getText();
			//return wait.until(ExpectedConditions.visibilityOfElementLocated(cartCounter)).getText();

	}	

		public void clickCartBtn() {
			driver.findElement(clickCartBtn).click();
		//	wait.until(ExpectedConditions.elementToBeClickable(clickCartBtn)).click();
	
	}
	
}

