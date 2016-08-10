package facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.io.File;

import facebook.util.Serialization;
import facebook.util.WebDriverInterface;

public abstract class FacebookPage {
	protected WebDriverInterface driverInterface;
	protected static final String LOGIN_COOKIE_DIR = "data\\logincookie\\";
	protected static final String LOGOUT_COOKIE_DIR = "data\\logoutcookie\\";
	
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
	
	
	public void setLoginCookie() {
		File dir = new File(LOGIN_COOKIE_DIR);
		File[] files = dir.listFiles();
		driverInterface.delAllCookies();
		for(File file : files) {
			Cookie cookie = (Cookie) Serialization.readObjectFromFile(file.getPath());
			driverInterface.addCookie(cookie);
		}
	}
	
	public void setLogoutCookie() {
		File dir = new File(LOGOUT_COOKIE_DIR);
		File[] files = dir.listFiles();
		driverInterface.delAllCookies();
		for(File file : files) {
			Cookie cookie = (Cookie) Serialization.readObjectFromFile(file.getPath());
			driverInterface.addCookie(cookie);
		}
	}
	
	public void close() {
		driverInterface.closePage();
	}
}
