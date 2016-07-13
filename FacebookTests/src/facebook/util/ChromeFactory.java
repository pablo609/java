package facebook.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;

public class ChromeFactory implements BrowserFactory {
	private static BrowserFactory factory = null;
	
	public static BrowserFactory getInstance() {
		if(factory == null) {
			System.setProperty("webdriver.chrome.driver","C:\\seleniumdrivers\\chromedriver.exe");
			factory = new ChromeFactory();
		}
		
		return factory;
	}
	
	@Override
	public WebDriver createWebDriver() {
		return new ChromeDriver();
	}

	@Override
	public MainLoginPage createMainLoginPage(WebDriver driver) {
		return new MainLoginPage(driver);
	}

	@Override
	public LoginPage createLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}

}
