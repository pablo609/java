package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
	
	@DataProvider(name = "RegistrationData")
	public Object[][] createRegistrationData() {
		String defFirstName = "Jan";
		String defLastName = "Kowalski";
		String defEmail = "kowalski@onetonet.pl";
		String defPassword = "Abcd123!";
		String defBirthdayDay = "1";
		String defBirthdayMonth = "1";
		String defBirthdayYear = "2000";
		String defSex = "male";
		
	return new Object[][] {
		{ "", defLastName, defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex },
		{ defFirstName, "", defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex },
		{ defFirstName, defLastName, "", defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex },
		{ defFirstName, defLastName, defEmail, "", defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex },
		{ defFirstName, defLastName, defEmail, defEmail, "", defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, "0", defBirthdayMonth, defBirthdayYear, defSex },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, defBirthdayDay, "0", defBirthdayYear, defSex },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, "0", defSex },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, "" },
		};
	}

	
	@Test(dataProvider = "RegistrationData")
	public void verifyMainLoginPageBadRegistration(
			String regFirstName,
			String regLastName,
			String regEmail,
			String regEmailConfirmation,
			String regPassword,
			String regBirthdayDay,
			String regBirthdayMonth,
			String regBirthdayYear,
			String regSex) {
		
		page.fillRegistrationForm(
				regFirstName,
				regLastName,
				regEmail,
				regEmailConfirmation,
				regPassword,
				regBirthdayDay,
				regBirthdayMonth,
				regBirthdayYear,
				regSex);
		page.submitRegistration();
		Assert.assertFalse(page.isProcessingRegistrationRequest());
		Assert.assertTrue(page.isLoaded());
		page.load();
	}
}
