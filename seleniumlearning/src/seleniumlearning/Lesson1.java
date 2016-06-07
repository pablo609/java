package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson1 {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://newtours.demoaut.com";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        
        driver.get(baseUrl);
        
        actualTitle = driver.getTitle();
        
        if(actualTitle.contentEquals(expectedTitle)) {
        	System.out.println("Test1 Passed");
        }
        else {
        	System.out.println("Test1 Failed");
        }
        
        driver.get("http://www.facebook.com");
        
        String tagname = driver.findElement(By.id("email")).getTagName();
        
        System.out.println(tagname);
        
        driver.get(baseUrl);
        
        WebElement usrname = driver.findElement(By.name("userName"));
        WebElement passwd = driver.findElement(By.name("password"));
        WebElement signin = driver.findElement(By.name("login"));
        
        usrname.sendKeys("pablo609");
        passwd.sendKeys("test");
        signin.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        
        driver.get("http://output.jsbin.com/usidix/1");
        
        driver.findElement(By.cssSelector("input[type=button]")).click();
        System.out.println(driver.switchTo().alert().getText());
        WebDriverWait timer = new WebDriverWait(driver, 10);
        
        driver.switchTo().alert().accept();
              
        //driver.close();
        
        System.exit(0);
	}
}
