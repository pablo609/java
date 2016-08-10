package facebook.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

public interface WebDriverInterface {
	String getPageTitle();
	void setText(By locator, String text);
	void click(By locator);
	boolean isElementPresent(By locator);
	void selectOption(By locator, String option);
	boolean isElementVisible(By locator);
	boolean isElementVisible(By locator, long timeoutInSec);
	boolean isElementVisible(By locator, long timeoutInSec, long pollingIntervalInMSec);
	void addCookie(Cookie cookie);
	void delAllCookies();
	Cookie getCookieNamed(String name);
	void refreshPage();
	void loadPage(String url);
	void closePage();
	List<WebElement> findAllElements(By locator);
}
