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
	boolean isElementVisible(By locator, Long timeoutInSec);
	boolean isElementVisible(By locator, Long timeoutInSec, Long pollingIntervalInMSec);
	Cookie getCookieNamed(String cookieName);
	void addCookie(Cookie cookie);
	void refreshPage();
	void loadPage(String url);
	void closePage();
}
