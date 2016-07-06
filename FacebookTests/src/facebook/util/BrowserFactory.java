package facebook.util;

import org.openqa.selenium.WebDriver;

import facebook.pages.*;

public interface BrowserFactory {
	WebDriver createWebDriver();
	MainLoginPage createMainLoginPage(WebDriver driver);
	LoginPage createLoginPage(WebDriver driver);
}
