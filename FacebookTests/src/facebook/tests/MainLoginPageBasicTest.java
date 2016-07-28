package facebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import facebook.pages.LoginPage;
import facebook.pages.MainLoginPage;
import facebook.util.BrowserFactory;
import facebook.util.FactorySelector;

public class MainLoginPageBasicTest {
	BrowserFactory factory = null;
	WebDriver driver = null;
	MainLoginPage page = null;
	
	@BeforeTest
	public void setup() {
		factory = FactorySelector.getBrowserFactory();
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
	public void verifyMainLoginPageBadLogin() throws InterruptedException {
		page.setEmailLogin("wronglogin");
		page.setPasswordLogin("wrongpass");
		page.logIn();
		LoginPage nextPage = factory.createLoginPage(driver);
		Assert.assertTrue(nextPage.isLoaded());
		page.load();
	}
	
	@DataProvider(name = "RegistrationData")
	public Object[][] createRegistrationData() {
		final String defFirstName = "Jan";
		final String defLastName = "Kowalski";
		final String defEmail = "kowalski@onetonet.pl";
		final String defPassword = "Abcd123!";
		final String defBirthdayDay = "1";
		final String defBirthdayMonth = "1";
		final String defBirthdayYear = "2000";
		final String defSex = "male";
		
		final By leftRedWarningNotice = By.cssSelector(".uiContextualLayer.uiContextualLayerLeft");
		final By belowRedWarningNotice = By.cssSelector(".uiContextualLayer.uiContextualLayerBelowLeft");
		
		return new Object[][] {
		{ "", defLastName, defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex, leftRedWarningNotice },
		{ defFirstName, "", defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex, belowRedWarningNotice },
		{ defFirstName, defLastName, "", defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex, leftRedWarningNotice },
		{ defFirstName, defLastName, defEmail, "", defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex, leftRedWarningNotice },
		{ defFirstName, defLastName, defEmail, defEmail, "", defBirthdayDay, defBirthdayMonth, defBirthdayYear, defSex, leftRedWarningNotice },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, "0", defBirthdayMonth, defBirthdayYear, defSex, leftRedWarningNotice },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, defBirthdayDay, "0", defBirthdayYear, defSex, leftRedWarningNotice },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, "0", defSex, leftRedWarningNotice },
		{ defFirstName, defLastName, defEmail, defEmail, defPassword, defBirthdayDay, defBirthdayMonth, defBirthdayYear, "", leftRedWarningNotice },
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
			String regSex,
			By redWarningNotice) {
		
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
		Assert.assertTrue(page.isElementVisible(redWarningNotice));
		page.load();
	}
}
