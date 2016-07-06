package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;
import facebook.util.BrowserFactory;
import facebook.util.FirefoxFactory;

public class MainLoginPageBasicTest {
	BrowserFactory factory = FirefoxFactory.getInstance();
	WebDriver driver = null;
	MainLoginPage page = null;
	
	@BeforeTest
	public void setup() {
		driver = factory.createWebDriver();
		page = factory.createMainLoginPage(driver);
		page.load();
	}
	
	@AfterTest
	public void cleanup() {
		driver.close();
	}
	
	@Test
	public void verifyMainLoginPageTitle() {
		Assert.assertTrue(page.isLoaded());
	}
	
	@Test
	public void verifyMainLoginPageBadLogin() {
		page.setEmailLogin("wronglogin");
		page.setPasswordLogin("wrongpass");
		page.logIn();
		LoginPage tmpPage = factory.createLoginPage(driver);
		Assert.assertTrue(tmpPage.isLoaded());
		page.load();
	}
}
