package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import facebook.util.BrowserFactory;
import facebook.util.FirefoxFactory;

public class Sandbox {
	@Test
	public void testing() {
		BrowserFactory factory = new FirefoxFactory();
		WebDriver driver = factory.createWebDriver();
		
		driver.get("https://www.facebook.com/");
		
		System.out.println(driver.manage().getCookieNamed("c_user"));
		
		driver.manage().deleteCookieNamed("c_user");
		
		driver.get("https://www.facebook.com/");
	}

}
