package facebook.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void verifySearchingForName() throws InterruptedException {
		final String searchName = "Jan Kowalski";
		Assert.assertTrue(page.isLoaded());
		page.setSearchInput(searchName);
		page.clickSearch();
		page.waitForSeeMoreSearchAndClick();
		List<WebElement> searchResult = page.waitForMoreSearchResultAndFindAllElements();
		Assert.assertFalse(searchResult.isEmpty());
		for(WebElement element : searchResult) {
			Assert.assertTrue(element.getText().contains(searchName));
		}
	}
}
