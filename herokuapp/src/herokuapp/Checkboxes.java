package herokuapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Checkboxes {
	private WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void setUp() {
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/checkboxes']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void test() {
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		Assert.assertFalse(checkboxes.get(0).isSelected());
		Assert.assertTrue(checkboxes.get(1).isSelected());
		
		checkboxes.get(0).click();
		checkboxes.get(1).click();
		
		Assert.assertTrue(checkboxes.get(0).isSelected());
		Assert.assertFalse(checkboxes.get(1).isSelected());
	}

}
