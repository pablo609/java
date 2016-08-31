package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/drag_and_drop'")).click();
	}
	
	public void tearDown() {
		
	}
	
	@Test
	public void test() throws Exception {
		WebElement elementA = driver.findElement(By.cssSelector("div#column-a>header"));
		WebElement elementB = driver.findElement(By.cssSelector("div#column-b>header"));
		
		Assert.assertEquals(elementA.getText(), "A");
		Assert.assertEquals(elementB.getText(), "B");
		
		Actions builder = new Actions(driver);
		//builder.moveToElement(elementA, 20, 100).clickAndHold().moveToElement(elementB, 20, 100).release().perform();
		builder.moveToElement(elementA).contextClick().perform();
		Thread.sleep(3000);
		//builder.dragAndDropBy(elementA, elementB.getLocation().getX()+10, elementB.getLocation().getY()+10).perform();
		
	}
}
