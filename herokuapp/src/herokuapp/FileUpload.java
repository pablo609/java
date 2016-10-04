package herokuapp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
	private WebDriver webDriver;
	
	@BeforeClass
	public void setUp() {
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get("http://the-internet.herokuapp.com");
		webDriver.findElement(By.cssSelector("a[href='/upload']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		webDriver.close();
	}

	@Test
	public void testFileUpload() {
		File file = new File("C:\\Users\\pawel\\Desktop\\issues.txt");
		WebElement fileBrowse = webDriver.findElement(By.id("file-upload"));
		fileBrowse.sendKeys(file.getAbsolutePath());
		
		WebElement fileUpload = webDriver.findElement(By.id("file-submit"));
		fileUpload.click();
		
		WebElement uploadedFile = webDriver.findElement(By.id("uploaded-files"));
		Assert.assertEquals(uploadedFile.getText(), file.getName());
	}
}
