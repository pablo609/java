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
		browserFactories.put(null, FirefoxFactory.getInstance());
		browserFactories.put("firefox", FirefoxFactory.getInstance());
		browserFactories.put("chrome", ChromeFactory.getInstance());
		browserFactories.put("ie", IEFactory.getInstance());
	}
	private static BrowserFactory selectedBrowserFactory = null;
	
	public static BrowserFactory getBrowserFactory() {
		if(selectedBrowserFactory == null) {
			selectedBrowserFactory = browserFactories.get(getBrowserPropertyValueFromFile());
		}
		
		return selectedBrowserFactory;
	}
	
	private static String getBrowserPropertyValueFromFile() {	
		Properties properties = readBrowserPropertyFromFile();
			
		if(properties != null)
			return properties.getProperty(BROWSER_PROPERTY_NAME);
		else
			return null;
	}
	
	private static Properties readBrowserPropertyFromFile() {
		File propertiesFile = new File(BROWSER_PROPERTIES_FILE);
		Properties properties = new Properties();
		
		try(FileInputStream propertiesInStream = new FileInputStream(propertiesFile)) {
			properties.load(propertiesInStream);
		}
		catch(IOException e) {
			e.printStackTrace();
			properties = null;
		}
		
		return properties;
	}
}
