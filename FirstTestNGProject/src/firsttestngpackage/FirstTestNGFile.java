package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.junit.Assert;

public class FirstTestNGFile {
	WebDriver driver = new FirefoxDriver();
	String baseURL = "http://newtours.demoaut.com/";
	
	@BeforeTest
	public void launchHomePage() {
		driver.get(baseURL);
	}
	
	@BeforeMethod
	public void verifyHomePageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String currentTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, currentTitle);
	}
	
	@AfterMethod
	public void goBackToHomePage() {
		driver.navigate().back();
	}
	
	@Test(priority = 1)
	public void verifyRegisterLink() {
		String expectedTitle = "Register: Mercury Tours";
		driver.findElement(By.linkText("REGISTER")).click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 0)
	public void verifySupportLink() {
		String expectedTitle = "Under Construction: Mercury Tours";
		driver.findElement(By.linkText("SUPPORT")).click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle+" ");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
