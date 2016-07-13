package facebook.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class FactorySelector {
	public static final String BROWSER_PROPERTY_NAME = "browser";
	public static final String BROWSER_PROPERTIES_FILE = "browser.properties";
	private static final HashMap<String, BrowserFactory> browserFactories = new HashMap<String, BrowserFactory>();
	static
	{
		browserFactories.put("firefox", FirefoxFactory.getInstance());
		browserFactories.put("chrome", ChromeFactory.getInstance());
		//System.setProperty("webdriver.ie.driver","C:\\seleniumdrivers\\IEDriverServer32.exe");
		//driver = new InternetExplorerDriver();
	}
	
	public static BrowserFactory getBrowserFactory() {
		BrowserFactory selectedBrowserFactory = browserFactories.get(getBrowserPropertyValueFromFile());
		
		if(selectedBrowserFactory == null) {
			selectedBrowserFactory = FirefoxFactory.getInstance();
		}
		
		return selectedBrowserFactory;
	}
	
	private static String getBrowserPropertyValueFromFile() {
		File propertiesFile = new File(BROWSER_PROPERTIES_FILE);
		Properties properties = new Properties();
		FileInputStream propertiesInStream = null;
		
		try {
			propertiesInStream = new FileInputStream(propertiesFile);
			properties.load(propertiesInStream);		
		}
		catch(IOException e) {
			e.printStackTrace();
			properties = null;
		}
		
		try {
			if(propertiesInStream != null)
				propertiesInStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		if(properties != null)
			return properties.getProperty(BROWSER_PROPERTY_NAME);
		else
			return null;
	}
}
