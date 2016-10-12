package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class ForgotPassword {
	WebDriver mainDriver;
	WebDriver emailDriver;
	
	@BeforeTest
	public void setUp() {
		mainDriver = new FirefoxDriver();
		mainDriver.manage().window().maximize();
		mainDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainDriver.get("http://the-internet.herokuapp.com");
		mainDriver.findElement(By.cssSelector("a[href='/forgot_password'")).click();
	}
	
	@AfterTest
	public void tearDown() {
		mainDriver.close();
		emailDriver.close();
	}

	@Test
	public void testForgottenPassword() {
		WebElement email = mainDriver.findElement(By.id("email"));
		WebElement retrieveButton = mainDriver.findElement(By.id("form_submit"));
				
		email.sendKeys(getEmailAddress());
		retrieveButton.click();
		WebElement emailSentText = mainDriver.findElement(By.id("content"));
		Assert.assertTrue(emailSentText.isDisplayed());
		Assert.assertTrue(isEmailRecieved());
	}
	
	private String getEmailAddress() {
		emailDriver = new FirefoxDriver();
		emailDriver.manage().window().maximize();
		emailDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		emailDriver.get("https://10minutemail.com");
		
		WebElement emailAddress = emailDriver.findElement(By.id("mailAddress"));
				
		return emailAddress.getAttribute("value");
	}
	
	private boolean isEmailRecieved() {
		By emailSubject = By.className("inc-mail-subject");
		
		boolean result = new FluentWait<WebDriver>(emailDriver)							
		.withTimeout(120, TimeUnit.SECONDS) 			
		.pollingEvery(500, TimeUnit.MILLISECONDS) 			
		.ignoring(NoSuchElementException.class)
		.until(new Function<WebDriver, Boolean>() {							
			public Boolean apply(WebDriver driver) {
				String emailSubjectText = driver.findElement(emailSubject).getText(); 
				return emailSubjectText.equals("Forgot Password from the-internet");
			}		
		});
		
		return result;
	}
}
