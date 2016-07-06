package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;
import facebook.util.BrowserFactory;
import facebook.util.FirefoxFactory;

public class LoginPageBasicTest {
	BrowserFactory factory = FirefoxFactory.getInstance();
	WebDriver driver = null;
	LoginPage page = null;
	
	@BeforeTest
	public void setup() {
		driver = factory.createWebDriver();
		page = factory.createLoginPage(driver);
		page.load();
	}
	
	@AfterTest
	public void cleanup() {
		driver.close();
	}
	
	@Test
	public void verifyLoginPageTitle() {
		Assert.assertTrue(page.isLoaded());
	}
	
	@Test
	public void verifyLoginPageBadLoginWarningAppears() {
		page.setEmailLogin("wronglogin");
		page.setPasswordLogin("wrongpassword");
		page.logIn();
		Assert.assertTrue(page.isBadLoginWarning());
		page.load();
	}
	
	@Test
	public void verifyLoginPageBadLoginDisappears() {
		page.setEmailLogin("wronglogin");
		page.setPasswordLogin("wrongpassword");
		page.logIn();
		Assert.assertTrue(page.isBadLoginWarning());
		page.load();
		Assert.assertFalse(page.isBadLoginWarning());
		page.load();
	}
}
