package seleniumlearning;

import org.openqa.selenium.WebDriver;

public class FacebookPage {
	public FacebookPage(WebDriver driver) {
		_driver = driver;
		loadMainPage();
	}
	public void close() {
		_driver.close();
	}
	public void loginOnMainPage() throws Exception {
		throw new Exception("Not on the Main Page!");
	}
	public void loadMainPage() {
		_driver.get("https://www.facebook.com/");
	}
	
	private WebDriver _driver;
}
