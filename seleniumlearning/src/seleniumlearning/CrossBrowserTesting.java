package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class CrossBrowserTesting {
	private WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional("ie") String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\seleniumdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver","C:\\seleniumdrivers\\IEDriverServer32.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	@Test
	public void Test() throws Exception {
		NewtoursPage page = new NewtoursPage(driver);
		page.loginOnMainPage();
		page.waitAndClose();
	}
}
