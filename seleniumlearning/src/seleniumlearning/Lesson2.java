package seleniumlearning;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
				
		driver.findElement(By.cssSelector("input[name=servClass][value=Business")).click();
		
		driver.findElement(By.linkText("Home")).click();
	
		try {
			page.loginOnMainPage();
		} catch (Exception e) {
			System.out.println(e.toString());
			page.close();
			System.exit(0);
		}
		
		Select airline = new Select(driver.findElement(By.name("airline")));
		
		airline.selectByVisibleText("Unified Airlines");
		
		if(airline.isMultiple())
			airline.deselectAll();
		
		try {
        	Thread.sleep(3000);
        } catch (Exception e) {}
		
		page.close();
	}
}
