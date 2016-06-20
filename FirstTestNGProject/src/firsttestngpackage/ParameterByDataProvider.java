package firsttestngpackage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class ParameterByDataProvider {
	WebDriver driver;
	
	@BeforeTest(groups={"A","B"})
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://google.com");
	}
	
	@Test(dataProvider="SearchProvider",groups="A")
	public void testMethodA(String author, String searchKey) throws InterruptedException {
		testMethod(author, searchKey);
	}
	
	@Test(dataProvider="SearchProvider",groups="B")
	public void testMethodB(String author, String searchKey) throws InterruptedException {
		testMethod(author, searchKey);
	}
	
	@AfterTest(groups={"A","B"})
	public void cleanup() {
		driver.close();
	}
	
	public void testMethod(String author, String searchKey) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		Thread.sleep(1000);
		System.out.println(searchText.getAttribute("value") + " ::: " + searchKey);
		Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
		searchText.clear();
	}
	
	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataprovider(ITestContext c){
		Object[][] array = null;
		for(String group : c.getIncludedGroups()) {
			System.out.println(group);
			if(group.equalsIgnoreCase("A")) {
				array = new Object[][] {
                		{ "Guru99A", "IndiaA" },
                		{ "KrishnaA", "UKA" },
                		{ "BhupeshA", "USAA" }};
                break;
			}
            else if(group.equalsIgnoreCase("B")){
            	array = new Object[][] {
            			{ "Guru99B", "India" },
            			{ "KrishnaB", "UK" },
            			{ "BhupeshB", "USA" }};
            	break;
            }
		}
		return array;
	}
}
