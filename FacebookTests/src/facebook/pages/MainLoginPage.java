package facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainLoginPage extends FacebookPage {
	By emailLogin = By.id("email");
	By passwordLogin = By.id("pass");
	By loginButton = By.cssSelector("input[value='Log In']");
	
	public MainLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void loadPage() {
		driver.get("https://www.facebook.com");
	}
	
	public void setEmailLogin(String text) {
		setText(this.emailLogin, text);
	}
	
	public void setPasswordLogin(String text) {
		setText(this.passwordLogin, text);
	}
	
	public void logIn() {
		click(this.loginButton);
	}
}
