package facebook.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import facebook.util.FactorySelector;

public class BrowserSelector {
	
	@Test
	@Parameters({"browser"})
	public void setBrowserForAllTests(String browser) throws IOException {
		Properties properties = new Properties();
		File propertiesFile = new File(FactorySelector.BROWSER_PROPERTIES_FILE);
		
		properties.setProperty(FactorySelector.BROWSER_PROPERTY_NAME, browser);
		
		FileOutputStream propertiesOutStream = null;
		try {
			propertiesOutStream = new FileOutputStream(propertiesFile);
			properties.store(propertiesOutStream, "The selected browser for the current Facebook Suites execution");
		}
		finally {
			if(propertiesOutStream != null)
				propertiesOutStream.close();
		}
	}
}
