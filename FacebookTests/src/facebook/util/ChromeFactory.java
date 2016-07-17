package facebook.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;

public class ChromeFactory implements BrowserFactory {
	private static BrowserFactory factory = null;
	
	public static BrowserFactory getInstance() {
		if(factory == null) {
			factory = new ChromeFactory();
		}
		
		return factory;
	}
	
	@Override
	public WebDriver createWebDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\seleniumdrivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=c:/seleniumdrivers/chromeprofile/");
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		return driver;
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
