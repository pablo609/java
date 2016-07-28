package facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;




public class FacebookPage {
	protected WebDriver driver;
	
	public FacebookPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void setText(By element, String text) {
		WebElement tmpElement = driver.findElement(element);
		tmpElement.clear();
		tmpElement.sendKeys(text);
	}
	
	public void click(By element) {
		driver.findElement(element).click();	
	}
	
	public boolean isElementPresent(By element) {
		if(driver.findElements(element).size() == 0)
			return false;
		else
			return true;
	}
	
	public void selectOption(By element, String option) {
		Select tmp = new Select(driver.findElement(element));
		tmp.selectByValue(option);
	}
	
	public boolean isElementVisible(By element) {
		return driver.findElement(element).isDisplayed();
	}
	
	public boolean isElementVisible(By element, Long timeoutInSec) {
		boolean retVal = true;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
		catch(TimeoutException e) {
			retVal = false;
		}
		
		return retVal;
	}
	
	public boolean isElementVisible(By element, Long timeoutInSec, Long pollingIntervalInMSec) {
		boolean retVal = true;
		
		try {
			new FluentWait<WebDriver>(driver)							
				.withTimeout(timeoutInSec, TimeUnit.SECONDS) 			
				.pollingEvery(pollingIntervalInMSec, TimeUnit.MILLISECONDS) 			
				.ignoring(NoSuchElementException.class)
				.until(new Function<WebDriver, Boolean>() {							
					public Boolean apply(WebDriver driver) { 
						return driver.findElement(element).isDisplayed();					
					}		
				});
		}
		catch(TimeoutException e) {
			retVal = false;
		}
		
		return retVal;
	}
	
	protected void setPageLanguagetoUS() {
		final String LANG_COOKIE_NAME = "locale";
		final String US_LANG_COOKIE_VALUE = "en_US";
		final String LANG_COOKIE_DOMAIN = ".facebook.com";
		final String LANG_COOKIE_PATH = "/";
		boolean cookieHasToBeUpdated = false;
		
		Cookie pageLanguageCookie = driver.manage().getCookieNamed(LANG_COOKIE_NAME);
		if(pageLanguageCookie == null)
			cookieHasToBeUpdated = true;
		else if(pageLanguageCookie.getValue().compareTo(US_LANG_COOKIE_VALUE) != 0)
			cookieHasToBeUpdated = true;

		if(cookieHasToBeUpdated) {
			Date currentDate = new Date();
			long currentTimeInMs = currentDate.getTime();
			final long FIVE_DAYS_IN_MS = 86400000l;
			Date cookieExpiryDate = new Date(currentTimeInMs + FIVE_DAYS_IN_MS);
			pageLanguageCookie = new Cookie(LANG_COOKIE_NAME, US_LANG_COOKIE_VALUE, LANG_COOKIE_DOMAIN, LANG_COOKIE_PATH, cookieExpiryDate);
			driver.manage().addCookie(pageLanguageCookie);
			driver.navigate().refresh();
		}
	}	
}
