package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	
	
	 @BeforeClass
	    public void setUp() {
		 
		 System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//executable//chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			driver.manage().window().maximize();
			
		    // open Sauce Demo page							
			driver.get("https://www.saucedemo.com/");
			
				
	    }
	 
	 public LoginPage getDriver() {
			return new LoginPage(driver);
			
		}
	 
	 
	 

	 @AfterClass
		public void tearDown() {
	//     	driver.quit();
	    
	    }
	 
	 
	
	/*
	    public void screenshot(String name) throws IOException {
	    	TakesScreenshot ts = (TakesScreenshot) driver;
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	File target = new File(System.getProperty("user.dir") + "/screenshots/" + name + ".png");
	    	FileUtils.copyFile(source, target);
		
	    }
	    */
	
		public void back() {
			driver.navigate().back();
			
		}
		
		public void refresh() {
			driver.navigate().refresh();
					
		}
		
}
