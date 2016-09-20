package herokuapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.testng.Assert;

public class DynamicControls {
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("a[href='/dynamic_controls']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testDynamicControls() {
		WebElement button = driver.findElement(By.id("btn"));
		By checkbox = By.cssSelector("input#checkbox");
		
		driver.findElement(checkbox).click();
		Assert.assertTrue(driver.findElement(checkbox).isSelected());
		
		button.click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new FluentWait<WebDriver>(driver)							
		.withTimeout(30, TimeUnit.SECONDS) 			
		.pollingEvery(500, TimeUnit.MILLISECONDS) 			
		.ignoring(NoSuchElementException.class)
		.until(new Function<WebDriver, Boolean>() {							
			public Boolean apply(WebDriver driver) { 
				List<WebElement> checkboxes = driver.findElements(checkbox);
				
				return checkboxes.isEmpty();
			}		
		});
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		List<WebElement> checkboxes = driver.findElements(checkbox);
		Assert.assertTrue(checkboxes.isEmpty());
		
		button.click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new FluentWait<WebDriver>(driver)							
		.withTimeout(30, TimeUnit.SECONDS) 			
		.pollingEvery(500, TimeUnit.MILLISECONDS) 			
		.ignoring(NoSuchElementException.class)
		.until(new Function<WebDriver, Boolean>() {							
			public Boolean apply(WebDriver driver) { 
				return driver.findElement(checkbox).isDisplayed();
			}		
		});
		
		Assert.assertTrue(driver.findElement(checkbox).isDisplayed());
	}
}
