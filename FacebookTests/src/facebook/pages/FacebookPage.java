package facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Date;

import facebook.util.WebDriverInterface;

public abstract class FacebookPage {
	protected WebDriverInterface driverInterface;
	private static final Cookie LANG_COOKIE;
	private static final Cookie LOGIN_COOKIE;
	static
	{
		final String LANG_COOKIE_NAME = "locale";
		final String LANG_COOKIE_VALUE = "en_US";
		final String LOGIN_COOKIE_NAME = "c_user";
		final String LOGIN_COOKIE_VALUE = "100012767310085";
		final String COOKIE_DOMAIN = ".facebook.com";
		final String COOKIE_PATH = "/";
		final boolean SECURE_COOKIE = true;
		Date currentDate = new Date();
		long currentTimeInMs = currentDate.getTime();
		final long THIRTY_DAYS_IN_MS = 86400000l * 30l;
		Date cookieExpiryDate = new Date(currentTimeInMs + THIRTY_DAYS_IN_MS);
		
		LANG_COOKIE = new Cookie(LANG_COOKIE_NAME, LANG_COOKIE_VALUE, COOKIE_DOMAIN, COOKIE_PATH, cookieExpiryDate);
		LOGIN_COOKIE = new Cookie(LOGIN_COOKIE_NAME, LOGIN_COOKIE_VALUE, COOKIE_DOMAIN, COOKIE_PATH, cookieExpiryDate, SECURE_COOKIE);
	}
	
	public abstract boolean isLoaded();
	public abstract void configureCookieAndLoad();
	public abstract void load();
	
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
	
	public void setLanguageCookietoUS() {
		if( ! isCookieConfiguredToValue(LANG_COOKIE.getName(), LANG_COOKIE.getValue())) {
			driverInterface.addCookie(LANG_COOKIE);
		}
	}
	
	public void setLoginCookie() {
		if( ! isCookieConfiguredToAnyValue(LOGIN_COOKIE.getName())) {
			driverInterface.addCookie(LANG_COOKIE);
		}
	}
	
	public void clearLoginCookie() {
		if(isCookieConfiguredToAnyValue(LOGIN_COOKIE.getName())) {
			driverInterface.delCookieNamed(LOGIN_COOKIE.getName());
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
	
	private boolean isCookieConfiguredToAnyValue(String cookieName) {
		Cookie cookie = driverInterface.getCookieNamed(cookieName);
		if(cookie == null)
			return false;
		
		return true;
	}
	
	public void close() {
		driverInterface.closePage();
	}
}
