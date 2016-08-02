package facebook.pages;

import org.openqa.selenium.By;

import facebook.util.WebDriverInterface;

public class MainPage extends FacebookPage {
	private static final String PAGE_TITLE = "Facebook";
	private static final String PAGE_URL = "https://www.facebook.com";
	private By searchInput = By.name("q");
	
	public MainPage(WebDriverInterface driverInterface) {
		super(driverInterface);
	}
	
	public boolean isLoaded() {
		return getPageTitle().equals(PAGE_TITLE);
	}
	
	public void configureCookieAndLoad() {
		driverInterface.loadPage(PAGE_URL);
		setLoginCookie();
		setLanguageCookietoUS();
		driverInterface.loadPage(PAGE_URL);
	}
	
	public void load() {
		driverInterface.loadPage(PAGE_URL);
	}
	
	public void setSearchInput(String text) {
		setText(searchInput, text);
	}
}
