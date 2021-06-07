package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
		
		protected WebDriver driver;
	    protected WebDriverWait wait;
	    
	  	 
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        
    }
   
    	public void visibilityOfElementLocated(By locator) {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    		
    }

    	public void elementToBeClickable(By locator) {
    		wait.until(ExpectedConditions.elementToBeClickable(locator));
        
    }

    	public void scrollToElement(By locator) {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
	}


}