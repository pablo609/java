package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;

public class LoginPageBasicTest {
	WebDriver driver = new FirefoxDriver();
	LoginPage page = null;
	
	@BeforeTest
	public void setup() {
		page = new LoginPage(driver);
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
		page.setPasswordLogin("");
		Assert.assertFalse(page.isBadLoginWarning());
		page.load();
	}
}
