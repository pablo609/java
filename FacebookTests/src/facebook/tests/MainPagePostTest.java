package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import facebook.pages.MainPage;
import facebook.util.BrowserFactory;
import facebook.util.FactorySelector;

public class MainPagePostTest {
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
	public void verifyMainPageAddingPost() {
		page.setPostInput("Test Post 123");
		page.clickPostButton();
		Assert.assertTrue(false, "Need to add verification if the post is on the page!");
	}
}
