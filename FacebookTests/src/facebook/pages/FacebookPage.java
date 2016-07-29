package facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Date;

import facebook.util.WebDriverInterface;

public class FacebookPage {
	protected WebDriverInterface driverInterface;
	
	public FacebookPage(WebDriverInterface driverInterface) {
		this.driverInterface = driverInterface;
	}
	
	public String getPageTitle() {
		return driverInterface.getPageTitle();
	}
	
	public void setText(By locator, String text) {
		driverInterface.setText(locator, text);
	}
	
	public void click(By locator) {
		driverInterface.click(locator);
	}
	
	public boolean isElementPresent(By locator) {
		return driverInterface.isElementPresent(locator);
	}
	
	public void selectOption(By locator, String option) {
		driverInterface.selectOption(locator, option);
	}
	
	public boolean isElementVisible(By locator) {
		return driverInterface.isElementVisible(locator);
	}
	
	public boolean isElementVisible(By locator, long timeoutInSec) {
		return driverInterface.isElementVisible(locator, timeoutInSec);
	}
	
	public boolean isElementVisible(By locator, long timeoutInSec, long pollingIntervalInMSec) {
		return driverInterface.isElementVisible(locator, timeoutInSec, pollingIntervalInMSec);
	}
	
	protected void setPageLanguageCookietoUS() {
		final String LANG_COOKIE_NAME = "locale";
		final String US_LANG_COOKIE_VALUE = "en_US";
		final String LANG_COOKIE_DOMAIN = ".facebook.com";
		final String LANG_COOKIE_PATH = "/";
		if( ! isCookieConfiguredToValue(LANG_COOKIE_NAME, US_LANG_COOKIE_VALUE)) {
			Date currentDate = new Date();
			long currentTimeInMs = currentDate.getTime();
			final long FIVE_DAYS_IN_MS = 86400000l;
			Date cookieExpiryDate = new Date(currentTimeInMs + FIVE_DAYS_IN_MS);
			Cookie pageLanguageCookie = new Cookie(LANG_COOKIE_NAME, US_LANG_COOKIE_VALUE, LANG_COOKIE_DOMAIN, LANG_COOKIE_PATH, cookieExpiryDate);
			driverInterface.addCookie(pageLanguageCookie);
		}
	}
	
	private boolean isCookieConfiguredToValue(String cookieName, String cookieVlue) {
		Cookie cookie = driverInterface.getCookieNamed(cookieName);
		if(cookie == null)
			return false;
		else if(cookie.getValue().compareTo(cookieVlue) != 0)
			return false;
		
		return true;
	}
	
	public void close() {
		driverInterface.closePage();
	}
}
