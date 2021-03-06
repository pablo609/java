package facebook.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import facebook.util.Serialization;
import facebook.util.WebDriverInterface;

public class MainPage extends FacebookPage {
	private static final String PAGE_TITLE = "Facebook";
	private static final String PAGE_URL = "https://www.facebook.com";
	private static final long WAIT_FOR_10SEC = 10l;
	private static final long CHECK_EVERY_500MS = 500l;
	
	private By searchInput = By.cssSelector("input[name='q'][role='combobox']"); //By.xpath("//input[@name='q'][@role='combobox']");
	private By searchButton = By.cssSelector("form[action$='direct_search.php']>button"); //By.xpath("//form[contains(@action,'direct_search.php')]/child::button"); 
	private By seeMoreSearch = By.cssSelector("a[href^='/search/str']"); //By.xpath("//a[starts-with(@href,'/search/str')]");
	private By searchedElementNamePattern = By.cssSelector("div#BrowseResultsContainer>div>div>div>div>div>div>div:nth-of-type(2)>div>a>div>div"); //By.xpath("//div[@id='BrowseResultsContainer']/descendant::div[6]/div[2]/div/a/descendant::div[2]");
	private By postInputEnabler = By.xpath("//textarea[contains(@title, 's on your mind')]/ancestor::div[1]");
	private By postInput = By.cssSelector("div#feedx_container>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div>div>div>div>div:nth-of-type(2)>div");
	private By postButton = By.cssSelector("div#feedx_container button");
	private By latestPost = By.cssSelector("div[id^='topnews_main_stream']>div[id^='feed_stream']>div>div>div:nth-of-type(2)>div>div:nth-of-type(4)>p");
	
	public MainPage(WebDriverInterface driverInterface) {
		super(driverInterface);
	}
	
	public boolean isLoaded() {
		return getPageTitle().equals(PAGE_TITLE);
	}
	
	public void configureCookieAndLoad() {
		driverInterface.loadPage(PAGE_URL);
		setLoginCookie();
		driverInterface.loadPage(PAGE_URL);
	}
	
	public void load() {
		driverInterface.loadPage(PAGE_URL);
	}
	
	public void setSearchInput(String text) {
		setText(searchInput, text);
	}
	
	public void clickSearch() {
		click(searchButton);
	}
	
	public void waitForSeeMoreSearchAndClick() {
		isElementVisible(seeMoreSearch, WAIT_FOR_10SEC, CHECK_EVERY_500MS);
		click(seeMoreSearch);
	}
	
	public List<WebElement> waitForMoreSearchResultAndFindAllElements() {	
		isElementVisible(searchedElementNamePattern, WAIT_FOR_10SEC, CHECK_EVERY_500MS);
		return driverInterface.findAllElements(searchedElementNamePattern);
	}
	
	public void readAndStoreAllCookies() {
		Set<Cookie> cookies = driverInterface.getAllCookies();
		
		for(Cookie cookie : cookies) {
			Serialization.writeObjectToFile(cookie, LOGIN_COOKIES_DIR + cookie.getName() + ".ser");
		}
	}
	
	public void setPostInput(String text) {
		click(postInputEnabler);
		isElementVisible(postInput, WAIT_FOR_10SEC, CHECK_EVERY_500MS);
		setText(postInput, text);
	}
	
	public void clickPostButton() {
		click(postButton);
	}
	
	public String getRecentlyPostedText() {
		if(isElementVisible(latestPost, WAIT_FOR_10SEC, CHECK_EVERY_500MS))
			return getText(latestPost);
		else
			return null;
	}
}
