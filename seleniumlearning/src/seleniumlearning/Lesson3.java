package seleniumlearning;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Lesson3 {
	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		NewtoursPage page = new NewtoursPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		page.loadMainPage();
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		String[] linkstext = new String[linkslist.size()];
		int i = 0;
		
		for(WebElement element : linkslist) {
			linkstext[i++] = element.getText();
		}
		
		for(String link : linkstext) {
			//driver.findElement(By.linkText(link)).click();
			if(driver.getTitle().equals("Under Construction: Mercury Tours"))
				System.out.println(link + " - " + "Still Under Construction");
			else
				System.out.println(link + " - " + "Finished");
			//driver.navigate().back();
		}
		
		FacebookPage facebook = new FacebookPage(driver);
		facebook.loadMainPage();
		driver.findElement(By.cssSelector("a[title='Go to Facebook Home']")).click();
		
		try {
        	Thread.sleep(3000);
        } catch (Exception e) {}
		
		page.close();
	}
}
