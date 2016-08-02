package facebook.util;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

public interface WebDriverInterface {
	String getPageTitle();
	void setText(By locator, String text);
	void click(By locator);
	boolean isElementPresent(By locator);
	void selectOption(By locator, String option);
	boolean isElementVisible(By locator);
	boolean isElementVisible(By locator, long timeoutInSec);
	boolean isElementVisible(By locator, long timeoutInSec, long pollingIntervalInMSec);
	Cookie getCookieNamed(String cookieName);
	void addCookie(Cookie cookie);
	void delCookieNamed(String name);
	void refreshPage();
	void loadPage(String url);
	void closePage();
}
