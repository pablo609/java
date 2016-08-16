package facebook.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxFactory extends BrowserFactory {
	private static BrowserFactory factory = null;
	
	public static BrowserFactory getInstance() {
		if(factory == null) {
			factory = new FirefoxFactory();
		}
		
		return factory;
	}
	
	@Override
	public WebDriver createWebDriver() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("selenium");
		WebDriver driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		return driver;
	}
}
