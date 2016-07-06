package facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends FacebookPage {
	private By badLoginWarning = By.xpath("//div[text() = 'Wrong Credentials']");
	private By passwordLogin = By.id("pass");
	private By emailLogin = By.id("email");
	private By loginButton = By.cssSelector("button[id='loginbutton']");
			
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void load() {
		driver.get("https://www.facebook.com/login.php");
	}
	
	public boolean isBadLoginWarning() {
		return isElementPresent(badLoginWarning);
	}
	
	public boolean isLoaded() {
		return getPageTitle().equals("Log in to Facebook | Facebook");
	}
	
	public void setPasswordLogin(String text) {
		setText(this.passwordLogin, text);
	}
	
	public void setEmailLogin(String text) {
		setText(this.emailLogin, text);
	}
	
	public void logIn() {
		click(this.loginButton);
	}
}
