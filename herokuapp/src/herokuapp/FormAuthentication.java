package herokuapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.base.Predicate;

import static org.testng.Assert.*;

public class FormAuthentication {
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Form Authentication")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testAuthenticationForm() {
		final String USERNAME = "tomsmith";
		final String PASSWORD = "SuperSecretPassword!";
		
		By userName = By.id("username");
		By password = By.id("password");
		By loginButton = By.cssSelector("button[type='submit']");
		By badLoginWarning = By.id("flash");
		By badLoginWarningClose = By.cssSelector("a.close");
		By secureArea = By.tagName("h2");
		
		driver.findElement(userName).sendKeys("wrongName");
		driver.findElement(password).sendKeys(PASSWORD);
		driver.findElement(loginButton).click();
		
		waitTillElementAppears(badLoginWarning);
		assertTrue(driver.findElement(badLoginWarning).getText().startsWith("Your username is invalid!"));
		
		driver.findElement(badLoginWarningClose).click();	
		waitTillElementDisappears(badLoginWarning);
			
		driver.findElement(userName).sendKeys(USERNAME);
		driver.findElement(password).sendKeys("wrongPassword");
		driver.findElement(loginButton).click();
		
		waitTillElementAppears(badLoginWarning);
		assertTrue(driver.findElement(badLoginWarning).getText().startsWith("Your password is invalid!"));
		
		driver.findElement(badLoginWarningClose).click();	
		waitTillElementDisappears(badLoginWarning);
		
		driver.findElement(userName).sendKeys(USERNAME);
		driver.findElement(password).sendKeys(PASSWORD);
		driver.findElement(loginButton).click();
		
		assertTrue(driver.findElement(secureArea).getText().startsWith("Secure Area"));
	}
	
	private void waitTillElementDisappears(By locator) {		
		new FluentWait<WebDriver>(driver)
			.withTimeout(10, TimeUnit.SECONDS)
			.pollingEvery(250, TimeUnit.MILLISECONDS)
		    .ignoring(NoSuchElementException.class)
		    .until(new Predicate<WebDriver>() {
		    	public boolean apply(WebDriver driver) {
		    		List<WebElement> list = driver.findElements(locator);
		    		return list.isEmpty();
		    	}
		    });
	}
	
	private void waitTillElementAppears(By locator) {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		
		driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
