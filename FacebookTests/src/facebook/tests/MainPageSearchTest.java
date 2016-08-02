package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebook.pages.MainPage;
import facebook.util.BrowserFactory;
import facebook.util.FactorySelector;

public class MainPageSearchTest {
	BrowserFactory factory = null;
	WebDriver driver = null;
	MainPage page = null;
	
	@BeforeTest
	public void setup() {
		factory = FactorySelector.getBrowserFactory();
		driver = factory.createWebDriver();
		page = factory.createMainPage(driver);
		page.configureCookieAndLoad();
	}
	
	@AfterTest
	public void cleanup() {
		page.close();
	}
	
	@Test
	public void f() {
		Assert.assertTrue(page.isLoaded());
		page.setSearchInput("Jan Kowalski");
	}
}
