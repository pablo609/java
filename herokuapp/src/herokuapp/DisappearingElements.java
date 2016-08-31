package herokuapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DisappearingElements {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/disappearing_elements'")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void test() {
		List<WebElement> buttons = driver.findElements(By.cssSelector("li>a"));
		Actions builder = new Actions(driver);
		for(WebElement button : buttons) {
			Assert.assertEquals(button.getCssValue("text-decoration-color"), "rgb(218, 75, 75)");
			builder.moveToElement(button).perform();
			Assert.assertEquals(button.getCssValue("text-decoration-color"), "rgb(0, 0, 0)");
		}
	}
}
