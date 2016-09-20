package herokuapp;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class ExitIntent {
private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("a[href='/exit_intent']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testExitIntent() throws Exception {
		WebElement close = driver.findElement(By.cssSelector("div.modal-footer>p"));
		Assert.assertFalse(close.isDisplayed());
		
		Robot robot = new Robot();
		robot.mouseMove(100, 100);
		robot.mouseMove(0, 0);
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
		.withTimeout(5, TimeUnit.SECONDS) 			
		.pollingEvery(200, TimeUnit.MILLISECONDS) 			
		.ignoring(NoSuchElementException.class);
		Boolean isCloseVisible = wait.until(new Function<WebDriver, Boolean>() {							
			public Boolean apply(WebDriver driver) { 
				return close.isDisplayed();
			}		
		});
		
		Assert.assertTrue(isCloseVisible);
		close.click();
		Assert.assertFalse(close.isDisplayed());
	}
}
