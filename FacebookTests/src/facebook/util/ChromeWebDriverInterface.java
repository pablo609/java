package facebook.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChromeWebDriverInterface extends CommonWebDriverInterface {
	private static final String DRIVER_PROCESS_NAME = "chromedriver";
	
	public ChromeWebDriverInterface(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public void setText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);

		//This is a workaround for an issue with ChromeDrive not always setting the text correctly
		//If this happens we are setting the text for the second time
		if(element.getAttribute("value").compareTo(text) != 0) {
			element.clear();
			element.sendKeys(text);
		}
	}
	
	@Override
	public void closePage() {
		driver.close();
		
		//This is a workaround for an issue with ChormeDrive process not being closed after calling close method
		if(ProcessManager.isProcessRunning(DRIVER_PROCESS_NAME)) {
			ProcessManager.killAllInstancesOfProcess(DRIVER_PROCESS_NAME);
		}
	}
}
