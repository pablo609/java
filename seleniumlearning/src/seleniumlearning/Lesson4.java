package seleniumlearning;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lesson4 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		NewtoursPage page = new NewtoursPage(driver);
		page.loadMainPage();
		
		WebElement linkHome = driver.findElement(By.linkText("Home"));
		WebElement tdLink = driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));
		WebElement linkDest = driver.findElement(By.linkText("Destinations"));
		WebElement linkCont = driver.findElement(By.linkText("CONTACT"));
		WebElement textUser = driver.findElement(By.name("userName"));
		
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(linkHome).build();
		
		String bgColor = tdLink.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);        
        mouseOverHome.perform();        
        bgColor = tdLink.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
        
        Action many = builder
        	.moveToElement(linkDest)
        	.moveToElement(textUser)
        	.keyDown(textUser, Keys.SHIFT)
        	.sendKeys(textUser, "p")
        	.keyUp(textUser, Keys.SHIFT)
        	.sendKeys(textUser, "awe³")
        	.doubleClick(textUser)
        	.contextClick(linkCont)
        	.build();
		
        many.perform();
        
		page.waitAndClose();
	}
}
