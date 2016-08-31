package herokuapp;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenImages {
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href='/broken_images']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void checkBrokeImages() throws Exception {
		List<WebElement> images = driver.findElements(By.cssSelector("div.example>img"));
		
		for(WebElement image: images) {
			Assert.assertEquals(verifyImageActive(image), hasImageGoodAddress(image), image.getAttribute("src"));
		}
	}
	
	private boolean verifyImageActive(WebElement image) throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(image.getAttribute("src"));
		HttpResponse response = client.execute(request);

		if (response.getStatusLine().getStatusCode() != 200) {
			return false;
		}

		return true;
	}
	
	private boolean hasImageGoodAddress(WebElement image) {
		String address = image.getAttribute("src");
		String goodAddressPattern = "http://the-internet.herokuapp.com/img/[\\w-]+\\.jpg";
		Matcher matcher = Pattern.compile(goodAddressPattern).matcher(address);
		
		return matcher.matches();
	}
}
