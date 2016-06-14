package seleniumlearning;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lesson4 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		NewtoursPage page = new NewtoursPage(driver);
		page.loadMainPage();
		
		WebElement linkHome = driver.findElement(By.linkText("Home"));
		WebElement tdLink = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));
		
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(linkHome).build();
		
		String bgColor = tdLink.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);        
        mouseOverHome.perform();        
        bgColor = tdLink.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
		
		page.waitAndClose();
	}
}
