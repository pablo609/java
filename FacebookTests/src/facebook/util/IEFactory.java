package facebook.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEFactory extends BrowserFactory {
	private static BrowserFactory factory = null;
	
	public static BrowserFactory getInstance() {
		if(factory == null) {
			factory = new IEFactory();
		}
		
		return factory;
	}
	
	@Override
	public WebDriver createWebDriver() {
		System.setProperty("webdriver.ie.driver","C:\\seleniumdrivers\\IEDriverServer32.exe");
		//Setting nativeEvents to false is a workaround for click functionality not always works in IE
		//Unfortunately it may cause other issues in the future
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		capabilities.setCapability("unexpectedAlertBehaviour", "accept");
//		capabilities.setCapability("ignoreProtectedModeSettings", true);
//		capabilities.setCapability("disable-popup-blocking", true);
//		capabilities.setCapability("enablePersistentHover", true);
		capabilities.setCapability("nativeEvents", false);
		return new InternetExplorerDriver(capabilities);
	}

}
