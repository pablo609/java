package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import facebook.pages.MainLoginPage;

public class MainLoginPageBasicTest {
	WebDriver driver = new FirefoxDriver();
	MainLoginPage page = null;
	
	@BeforeTest
	public void setup() {
		page = new MainLoginPage(driver);
		page.loadPage();
	}
	
	@AfterTest
	public void cleanup() {
		driver.close();
	}
	
	@Test
	public void verifyMainLoginPageTitle() {
		Assert.assertEquals(page.getPageTitle(), "Facebook - Log In or Sign Up");
	}
	
	@Test
	public void verifyMainLoginPageBadLogin() {
		page.setEmailLogin("wrong");
		page.setPasswordLogin("wrongpass");
		page.logIn();
		page.loadPage();
	}
}
