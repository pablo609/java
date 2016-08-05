package facebook.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class CommonWebDriverInterface implements WebDriverInterface {
	protected WebDriver driver;
	
	public CommonWebDriverInterface(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void setText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();	
	}
	
	public boolean isElementPresent(By locator) {
		if(driver.findElements(locator).size() == 0)
			return false;
		else
			return true;
	}
	
	public void selectOption(By locator, String option) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(option);
	}
	
	public boolean isElementVisible(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public boolean isElementVisible(By locator, long timeoutInSec) {
		boolean retVal = true;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(TimeoutException e) {
			retVal = false;
		}
		
		return retVal;
	}
	
	public boolean isElementVisible(By locator, long timeoutInSec, long pollingIntervalInMSec) {
		boolean retVal = true;
		
		try {
			new FluentWait<WebDriver>(driver)							
				.withTimeout(timeoutInSec, TimeUnit.SECONDS) 			
				.pollingEvery(pollingIntervalInMSec, TimeUnit.MILLISECONDS) 			
				.ignoring(NoSuchElementException.class)
				.until(new Function<WebDriver, Boolean>() {							
					public Boolean apply(WebDriver driver) { 
						return driver.findElement(locator).isDisplayed();					
					}		
				});
		}
		catch(TimeoutException e) {
			retVal = false;
		}
		
		return retVal;
	}
	
	public Cookie getCookieNamed(String cookieName) {
		return driver.manage().getCookieNamed(cookieName);
	}
	
	public void addCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}
	
	public void delCookieNamed(String name) {
		driver.manage().deleteCookieNamed(name);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void loadPage(String url) {
		driver.get(url);
	}
	
	public void closePage() {
		driver.quit();
	}
	
	public List<WebElement> findAllElements(By locator) {
		return driver.findElements(locator);
	}
}
