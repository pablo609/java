package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/drag_and_drop'")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test(enabled = false)
	public void test() throws Exception {
		if(true) {
			throw new SkipException("Drag And Drop doesn't work in HTML5");
		}
		else {
			WebElement elementA = driver.findElement(By.cssSelector("div#column-a"));
			WebElement elementB = driver.findElement(By.cssSelector("div#column-b"));
			
			Assert.assertEquals(elementA.getText(), "A");
			Assert.assertEquals(elementB.getText(), "B");
			
			Actions builder = new Actions(driver);
	
			builder.dragAndDrop(elementA, elementB).perform();
	
			Assert.assertEquals(elementA.getText(), "B");
			Assert.assertEquals(elementB.getText(), "A");
		}
	}
}
