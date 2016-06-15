package firsttestngpackage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ParameterWithTestNGXML {
	@Test
	@Parameters({"author","searchKey"})
	public void testParameterWithXML(@Optional("Abc") String author, String searchKey) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
		System.out.println("Thread will sleep now");
		Thread.sleep(1000);
		System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
		Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
		driver.close();
	}
}
