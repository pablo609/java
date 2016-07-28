package facebook.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;

public class ChromeFactory extends BrowserFactory {
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
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	@Override
	public LoginPage createLoginPage(WebDriver driver) {
		return new LoginPage(new ChromeWebDriverInterface(driver));
	}
	
	@Override
	public MainLoginPage createMainLoginPage(WebDriver driver) {
		return new MainLoginPage(new ChromeWebDriverInterface(driver));
	}
}
