package facebook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import facebook.pages.MainLoginPage;
import facebook.pages.MainPage;
import facebook.util.BrowserFactory;
import facebook.util.FactorySelector;

public class LoginCookieCollector {

	@Test
	public void loginAndStoreSessionCookie() {
		BrowserFactory factory = FactorySelector.getBrowserFactory();
		WebDriver driver = factory.createWebDriver();
		MainLoginPage loginPage = factory.createMainLoginPage(driver);
		MainPage mainPage = factory.createMainPage(driver);
		
		loginPage.configureCookieAndLoad();
		loginPage.setEmailLogin("john602@o2.pl");
		loginPage.setPasswordLogin("John602");
		loginPage.logIn();
		Assert.assertTrue(mainPage.isLoaded());
		mainPage.readAndStoreLoginCookie();
		mainPage.close();
	}
}
