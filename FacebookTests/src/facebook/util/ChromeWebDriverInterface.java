package facebook.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChromeWebDriverInterface extends CommonWebDriverInterface {
	
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
		//TODO:This is a workaround for an issue with ChormeDrive process not being closed after calling close method
		//It still doesn't work
		//Check the same issue with IE
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
