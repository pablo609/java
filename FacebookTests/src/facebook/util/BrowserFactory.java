package facebook.util;

import org.openqa.selenium.WebDriver;

import facebook.pages.*;

public abstract class BrowserFactory {
	public abstract WebDriver createWebDriver();
	
	public MainLoginPage createMainLoginPage(WebDriver driver) {
		return new MainLoginPage(new CommonWebDriverInterface(driver));
	}
	
	public LoginPage createLoginPage(WebDriver driver) {
		return new LoginPage(new CommonWebDriverInterface(driver));
	}
	
	public MainPage createMainPage(WebDriver driver) {
		return new MainPage(new CommonWebDriverInterface(driver));
	}
}
