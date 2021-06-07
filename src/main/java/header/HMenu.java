package header;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.BasePage;


public class HMenu extends BasePage {
		
	//Locators ************************************************************************************************ 
	private By clickHMenuBtn = By.className("bm-burger-button");
	private By clickCloseHMenu = By.className("bm-cross-button");
	// all 4 links
	private By hMenuLinks = By.className("bm-item-list");
	// 4 links
	private By clickLogoutFromHMenu = By.id("logout_sidebar_link");
	private By clickAllItemsFromHMenu = By.id("inventory_sidebar_link");
	private By clickHMenuAbout = By.id("about_sidebar_link");
	private By clickResetAppStateFromHMenu = By.id("reset_sidebar_link");
	
	//Constructor ************************************************************************************************ 
		public HMenu(WebDriver driver) {
			super(driver);
		
	}

		public void clickHMenuBtn() {
			driver.findElement(clickHMenuBtn).click();
			
	}	
		
		public String getHMenuLinks() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(hMenuLinks));
			return driver.findElement(hMenuLinks).getText();
		
	}
		
		public void clickAllItemsFromHMenu() {
			wait.until(ExpectedConditions.elementToBeClickable(clickHMenuBtn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(clickAllItemsFromHMenu)).click();
					
	}
				
		public void clickHMenuAbout() {
			wait.until(ExpectedConditions.elementToBeClickable(clickHMenuBtn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(clickHMenuAbout)).click();

	}
		
		public void clickLogoutFromHMenu() {
			wait.until(ExpectedConditions.elementToBeClickable(clickHMenuBtn)).click();
		//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(clickLogoutFromHMenu)).click();
		
	}	
		//	Note* after <Reset app> it is necessary to refresh the page, 
		// the cart is empty, but the buttons still display the status before resetting 		
		
		public void clickResetAppStateFromHMenu() {
			wait.until(ExpectedConditions.elementToBeClickable(clickHMenuBtn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(clickResetAppStateFromHMenu)).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(clickCloseHMenu)).click();
						
	}

		public void clickCloseHMenu() {
			wait.until(ExpectedConditions.elementToBeClickable(clickCloseHMenu)).click();
		
	}
	
		public String verifyNewSaucelabsPageIsOpen() {
			System.out.println("Page title | " + driver.getTitle());	
			return driver.getCurrentUrl();
		
	}

	
}
