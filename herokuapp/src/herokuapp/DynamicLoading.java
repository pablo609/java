package herokuapp;

import java.util.List;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class DynamicLoading {
	private WebDriver driver;
	private By text = By.cssSelector("div#finish>h4");
	private By button = By.cssSelector("div#start>button");
	private String textValue = "Hello World!";
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void setUpMethod() {
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("a[href='/dynamic_loading']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testExample1() {
		driver.findElement(By.cssSelector("a[href='/dynamic_loading/1']")).click();
		
		WebElement elementButton = driver.findElement(button);
		WebElement elementText = driver.findElement(text);
		
		Assert.assertFalse(elementText.isDisplayed());
		elementButton.click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
		.withTimeout(30, TimeUnit.SECONDS) 			
		.pollingEvery(500, TimeUnit.MILLISECONDS) 			
		.ignoring(NoSuchElementException.class);
		Boolean isTextVisible = wait.until(new Function<WebDriver, Boolean>() {							
			public Boolean apply(WebDriver driver) { 
				return elementText.isDisplayed();
			}		
		});
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(isTextVisible);
		Assert.assertEquals(elementText.getText(), textValue);
	}
	
	@Test
	public void testExample2() {
		driver.findElement(By.cssSelector("a[href='/dynamic_loading/2']")).click();
		
		WebElement elementButton = driver.findElement(button);
		elementButton.click();
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new FluentWait<WebDriver>(driver)							
		.withTimeout(30, TimeUnit.SECONDS) 			
		.pollingEvery(500, TimeUnit.MILLISECONDS) 			
		.ignoring(NoSuchElementException.class)
		.until(new Function<WebDriver, Boolean>() {							
			public Boolean apply(WebDriver driver) { 
				return driver.findElement(text).isDisplayed();
			}		
		});
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(text).isDisplayed());
		Assert.assertEquals(driver.findElement(text).getText(), textValue);
	}
}
