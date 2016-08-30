package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

public class ContextMenu {
private WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void setUp() {
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/context_menu']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void test() throws Exception {
		WebElement rightClickArea = driver.findElement(By.id("hot-spot"));
		
		Actions builder = new Actions(driver);
        Action action = builder
                .moveToElement(rightClickArea)
                .contextClick()
                .build();
        action.perform();
        builder.sendKeys(Keys.chord("t")).build().perform();
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
        driver.switchTo().alert().accept();
	}
}
