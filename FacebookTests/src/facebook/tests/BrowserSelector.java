package facebook.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import facebook.util.FactorySelector;

public class BrowserSelector {
	
	@Test
	@Parameters({"browser"})
	public void setBrowserPropertyValueInFile(String browser) {
		Properties browserProperty = new Properties();
		browserProperty.setProperty(FactorySelector.BROWSER_PROPERTY_NAME, browser);
		
		writeBrowserPropertyToFile(browserProperty);
	}
	
	private void writeBrowserPropertyToFile(Properties browserProperty) {
		File propertiesFile = new File(FactorySelector.BROWSER_PROPERTIES_FILE);
		
		try(FileOutputStream propertiesOutStream = new FileOutputStream(propertiesFile)) {
			browserProperty.store(propertiesOutStream, "The selected browser for the current Facebook Suites execution");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
