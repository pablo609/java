package seleniumlearning;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Lesson2 {
	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		NewtoursPage page = new NewtoursPage(driver);
		
		try {
			page.loginOnMainPage();
		} catch (Exception e) {
			System.out.println(e.toString());
			page.close();
			System.exit(0);
		}
				
		driver.findElement(By.cssSelector("input[value=Business])"));
		//serviceclass.click();
		
		try {
        	Thread.sleep(3000);
        } catch (Exception e) {}
		
		page.close();
	}
}
