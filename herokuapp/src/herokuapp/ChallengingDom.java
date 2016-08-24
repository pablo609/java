package herokuapp;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengingDom {
	private WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void setUp() {
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("a[href='/challenging_dom']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void checkTextInColumns() {
		verifyColumnText(1, "Iuvaret");
		verifyColumnText(2, "Apeirian");
		verifyColumnText(3, "Adipisci");
		verifyColumnText(4, "Definiebas");
		verifyColumnText(5, "Consequuntur");
		verifyColumnText(6, "Phaedrum");
	}
	
	private void verifyColumnText(int columnNumber, String textBeginning) {
		List<WebElement> column = driver.findElements(By.cssSelector("tbody>tr>td:nth-child(" + columnNumber + ")"));
		Iterator<WebElement> iterator = column.iterator();
		for(int i = 0; iterator.hasNext(); ++i) {
			WebElement element = iterator.next();
			Assert.assertEquals(element.getText(), textBeginning + i);
		}
	}
}
