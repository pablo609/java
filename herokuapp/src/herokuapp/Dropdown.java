package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Dropdown {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/dropdown'")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void test() {
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select selectList = new Select(dropdown);
		
		Assert.assertEquals(selectList.getFirstSelectedOption().getText(), "Please select an option" );
		
		selectList.selectByValue("1");
		Assert.assertEquals(selectList.getFirstSelectedOption().getText(), "Option 1" );
		
		selectList.selectByVisibleText("Option 2");
		Assert.assertEquals(selectList.getFirstSelectedOption().getText(), "Option 2" );
	}
}
