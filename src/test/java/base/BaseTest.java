package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import footer.Footer;
import header.CartIcon;
import header.HMenu;
import pages.CartPage;
import pages.Checkout1YourInfoPage;
import pages.Checkout2OverviewPage;
import pages.Checkout3CompletePage;
import pages.InventoryItemsPage;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	protected LoginPage login;
    protected InventoryPage inventory;
    protected CartPage cart;
    protected InventoryItemsPage itemsPage;
    protected Checkout3CompletePage checkout3;
    protected Checkout2OverviewPage checkout2;
    protected Checkout1YourInfoPage checkout1;
    protected HMenu hMenu;
    protected CartIcon carti;
    protected Footer footer;
    
      //                 itemName                                       itemPrice     
    	protected String itemSauceLabsBackpack = "Sauce Labs Backpack", priceSauceLabsBackpack = "29.99";
    	protected String itemSauceLabsBikeLight = "Sauce Labs Bike Light", priceSauceLabsBikeLight = "9.99";
    	protected String itemSauceLabsBoltTShirt = "Sauce Labs Bolt T-Shirt", priceSauceLabsBoltTShirt = "15.99";
    	protected String itemSauceLabsFleeceJacket = "Sauce Labs Fleece Jacket", priceSauceLabsFleeceJacket = "49.99";
    	protected String itemSauceLabsOnesie = "Sauce Labs Onesie", priceSauceLabsOnesie = "7.99";
    	protected String itemTestallTheThingsTShirtRed = "Test.allTheThings() T-Shirt (Red)", priceTestallTheThingsTShirtRed = "15.99";
	
	
	 @BeforeClass
	    public void setUp() {
		 System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//executable//chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
												
			driver.get("https://www.saucedemo.com/");
			initPage();
				
	    }

	 @AfterClass
		public void tearDown() {
	     	driver.quit();
	    
	    }
	 
	 public void initPage() {
		 	login = new LoginPage(driver);
			inventory = new InventoryPage(driver);
			itemsPage = new InventoryItemsPage(driver);
			cart = new CartPage(driver);
			checkout1 = new Checkout1YourInfoPage(driver);
			checkout2 = new Checkout2OverviewPage(driver);
			checkout3 = new Checkout3CompletePage(driver);
			hMenu = new HMenu(driver);
			carti = new CartIcon(driver);
			footer = new Footer(driver);
	
	 }
	 
	    public void screenshot(String name) throws IOException {
	    	TakesScreenshot ts = (TakesScreenshot) driver;
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	File target = new File(System.getProperty("user.dir") + "/screenshots/" + name + ".png");
	    	FileUtils.copyFile(source, target);
		
	    }
	
		public void back() {
			driver.navigate().back();
			
		}
		
		public void refresh() {
			driver.navigate().refresh();
					
		}
		
}
