package facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class FacebookPage {
	protected WebDriver driver;
	
	public FacebookPage(WebDriver driver) {
		this.driver = driver;
		//this.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void setText(By element, String text) {
		WebElement tmpElement = driver.findElement(element);
		tmpElement.clear();
		tmpElement.sendKeys(text);
	}
	
	public void click(By element) {
		driver.findElement(element).click();
	}
	
	public boolean isElementPresent(By element) {
		if(driver.findElements(element).size() == 0)
			return false;
		else
			return true;
	}
}
