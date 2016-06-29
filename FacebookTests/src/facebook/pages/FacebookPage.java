package facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class FacebookPage {
	protected WebDriver driver;
	
	public FacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void setText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}
	
	public void click(By element) {
		driver.findElement(element).click();
	}
}
