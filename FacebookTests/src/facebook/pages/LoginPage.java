package facebook.pages;

import org.openqa.selenium.By;

import facebook.util.WebDriverInterface;

public class LoginPage extends FacebookPage {
	private static final String PAGE_TITLE = "Log into Facebook | Facebook";
	private static final String PAGE_URL = "https://www.facebook.com/login.php";
	private By badLoginWarningV1 = By.xpath("//div[starts-with(text(),'The email')]");
	private By badLoginWarningV2 = By.xpath("//div[text() = 'Wrong Credentials']");
	private By passwordLogin = By.id("pass");
	private By emailLogin = By.id("email");
	private By loginButton = By.cssSelector("button[id='loginbutton']");
			
	public LoginPage(WebDriverInterface driverInterface) {
		super(driverInterface);
	}
	
	public void configureCookieAndLoad() {
		driverInterface.loadPage(PAGE_URL);
		clearLoginCookie();
		setLanguageCookietoUS();
		driverInterface.loadPage(PAGE_URL);;
	}
	
	public void load() {
		driverInterface.loadPage(PAGE_URL);
	}
	
	public boolean isBadLoginWarning() {
		if(isElementPresent(badLoginWarningV1))
			return isElementVisible(badLoginWarningV1);
		else
			return isElementPresent(badLoginWarningV2);
	}
	
	public boolean isLoaded() {
		return getPageTitle().equals(PAGE_TITLE);
	}
	
	public void setPasswordLogin(String text) {
		setText(passwordLogin, text);
	}
	
	public void setEmailLogin(String text) {
		setText(emailLogin, text);
	}
	
	public void logIn() {
		click(loginButton);
	}
}
