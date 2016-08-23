package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ABTesting {
	private WebDriver driver = new FirefoxDriver();
	private static final String ADDRESS = "http://the-internet.herokuapp.com";
	private static final By LINK = By.cssSelector("a[href='/abtest']");
	
	@BeforeClass
	public void setUp() {
		driver.get(ADDRESS);
		driver.manage().window().maximize();
		driver.findElement(LINK).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void checkText() {
		WebElement header = driver.findElement(By.cssSelector("h3"));
		Assert.assertTrue(header.getText().startsWith("A/B Test"), header.getText());
		
		WebElement text = driver.findElement(By.cssSelector("div.example>p"));
		Assert.assertTrue(text.getText().startsWith("Also known as split testing."), text.getText());
	}
}
