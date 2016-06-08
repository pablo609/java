package seleniumlearning;

import org.openqa.selenium.TimeoutException;
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
        
        if(usrname.isEnabled())
        	usrname.sendKeys("tutorial");
        passwd.sendKeys("tutorial");
        signin.click();
        System.out.println(driver.getCurrentUrl());
        
        WebElement radiobutton = driver.findElement(By.cssSelector("input[value=oneway]"));
        System.out.println(radiobutton.isSelected());
        if(!radiobutton.isSelected())
        	radiobutton.click();
        try {
        	Thread.sleep(3000);
        } catch (Exception e) {}
        driver.navigate().back();
        
        driver.get("http://output.jsbin.com/usidix/1");
        
        driver.findElement(By.cssSelector("input[type=button]")).click();
        System.out.println(driver.switchTo().alert().getText());
        WebDriverWait timer = new WebDriverWait(driver, 5);
        driver.switchTo().alert().accept();
        timer.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[type=button]")));
        
        try {
        	timer.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("nonexisting")));
        } catch (TimeoutException te) {
        	System.out.println(te.toString());
        }
              
        driver.close();
        
        System.exit(0);
	}
}
