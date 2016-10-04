package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenu {
private WebDriver webDriver;
	
	@BeforeClass
	public void setUp() {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get("http://the-internet.herokuapp.com");
		webDriver.findElement(By.cssSelector("a[href='/floating_menu']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		webDriver.close();
	}

	@Test
	public void testFloatingMenu() {
		WebElement homeMenu = webDriver.findElement(By.cssSelector("a[href='#home']"));
		
		int initialXLocation = homeMenu.getLocation().getX();
		
		int windowHeight = webDriver.manage().window().getSize().getHeight();
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		
		jse.executeScript("window.scrollBy(0, " + Integer.toString(windowHeight) + ")", "");
		Assert.assertEquals(homeMenu.getLocation().getX(), initialXLocation);
		Assert.assertEquals(homeMenu.getLocation().getY(), windowHeight - 1);
		
		jse.executeScript("window.scrollBy(0, " + Integer.toString(windowHeight) + ")", "");
		Assert.assertEquals(homeMenu.getLocation().getX(), initialXLocation);
		Assert.assertEquals(homeMenu.getLocation().getY(), (windowHeight * 2));
	}
}
