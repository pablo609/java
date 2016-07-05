package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;

public class MainLoginPageBasicTest {
	WebDriver driver = new FirefoxDriver();
	MainLoginPage page = null;
	
	@BeforeTest
	public void setup() {
		page = new MainLoginPage(driver);
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
		LoginPage tmpPage = new LoginPage(driver);
		Assert.assertTrue(tmpPage.isLoaded());
		page.load();
	}
}
