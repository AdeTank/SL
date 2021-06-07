package footer;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages.BasePage;


public class Footer extends BasePage {
		
	//Locators ************************************************************************************************ 
	private By twitter = By.className("social_twitter");
	private By facebook = By.className("social_facebook");
	private By linkedin = By.className("social_linkedin");
	
	
	//Constructor ************************************************************************************************ 
		public Footer(WebDriver driver) {
			super(driver);
		
	}

		public void clickTwitter() {
			wait.until(ExpectedConditions.elementToBeClickable(twitter)).click();
			
	}	
				
		public void clickFacebook() {
			wait.until(ExpectedConditions.elementToBeClickable(facebook)).click();
		
	}
				
		public void clickLinkedin() {
			wait.until(ExpectedConditions.elementToBeClickable(linkedin)).click();
		
	}
				
		public void verifySaucelabsTwitterPageIsOpen() {
			String SaucePage = driver.getWindowHandle();
			Set<String> allHandles = driver.getWindowHandles();
			for(String TwitterPage : allHandles){
			    driver.switchTo().window(TwitterPage);
			}
			    Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/saucelabs", 
						"User is not on <Saucelabs> Twitter page");
			    
			    System.out.println("Page URL | " + driver.getCurrentUrl());	
			    
			driver.close(); 
		 	driver.switchTo().window(SaucePage);
					
		}
			
		public void verifySaucelabsFacebookPageIsOpen() {
			String SaucePage = driver.getWindowHandle();
			Set<String> allHandles = driver.getWindowHandles();
			for(String FacebookPage : allHandles){
			    driver.switchTo().window(FacebookPage);
			}
			    Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs", 
						"User is not on <Saucelabs> Facebook page");
			    
			    System.out.println("Page URL | " + driver.getCurrentUrl());	
			    
			driver.close(); 
		 	driver.switchTo().window(SaucePage);
					
		}

		public void verifySaucelabsLinkedinPageIsOpen() {
			String SaucePage = driver.getWindowHandle();
			Set<String> allHandles = driver.getWindowHandles();
			for(String LinkedinPage : allHandles){
			    driver.switchTo().window(LinkedinPage);
			}
			 //   Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/", 
			//			"User is not on <Saucelabs> Linkedin page");
			    
			    System.out.println("Page URL | " + driver.getTitle());	
			    
			driver.close(); 
		 	driver.switchTo().window(SaucePage);
					
			
		}
	
}
