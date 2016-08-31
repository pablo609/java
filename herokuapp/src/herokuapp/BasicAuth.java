package herokuapp;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuth {
	private WebDriver driver;
	private static final String ADDRESS = "http://the-internet.herokuapp.com";
	private static final String LINK = "/basic_auth";
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(ADDRESS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void checkAuthorization() {
		//Getting the credentials from the main page
		WebElement credentials = driver.findElement(By.cssSelector("ul>li:nth-child(2)"));
		String pattern = ".*:\\s*(\\w+)";
		Matcher matcher = Pattern.compile(pattern).matcher(credentials.getText());
		matcher.find();
		String userOrPass = matcher.group(1);
		
		//Authorization by providing the credentials via URL
		driver.get("http://" + userOrPass + ":" + userOrPass + "@" + ADDRESS.substring(7) + LINK);
		WebElement header = driver.findElement(By.cssSelector("h3"));
		Assert.assertEquals(header.getText(), "Basic Auth");
	}

}
