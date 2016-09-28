package herokuapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownload {
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("a[href='/download']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testFileDownload() throws Exception {
		WebElement file1 = driver.findElement(By.cssSelector("div.example>a:nth-of-type(1)"));
		WebElement file2 = driver.findElement(By.cssSelector("div.example>a:nth-of-type(2)"));
		WebElement file3 = driver.findElement(By.cssSelector("div.example>a:nth-of-type(3)"));
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpHead request;
		HttpResponse response;
		String contentType;
		int contentLength;
		
		request= new HttpHead(file1.getAttribute("href"));
		response = httpClient.execute(request);
		contentType = response.getFirstHeader("Content-Type").getValue();
		contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
		Assert.assertEquals(contentType, "application/octet-stream");
		Assert.assertEquals(contentLength, 307);
		
		request= new HttpHead(file2.getAttribute("href"));
		response = httpClient.execute(request);
		contentType = response.getFirstHeader("Content-Type").getValue();
		contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
		Assert.assertEquals(contentType, "application/vnd.ms-excel");
		Assert.assertEquals(contentLength, 0);
		
		request= new HttpHead(file3.getAttribute("href"));
		response = httpClient.execute(request);
		contentType = response.getFirstHeader("Content-Type").getValue();
		contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
		Assert.assertEquals(contentType, "text/csv;charset=utf-8");
		Assert.assertEquals(contentLength, 6169);
	}
}
