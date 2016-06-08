package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class NewtoursPage {
	public NewtoursPage(WebDriver driver) {
		_driver = driver;
		driver.get("http://newtours.demoaut.com/");
	}
	public void close() {
		_driver.close();
	}
	public void loginOnMainPage() throws Exception {
		if(_driver.getTitle().equals("Welcome: Mercury Tours"))
		{
			WebElement usrname = _driver.findElement(By.name("userName"));
			WebElement passwd = _driver.findElement(By.name("password"));
			WebElement signin = _driver.findElement(By.name("login"));
			usrname.sendKeys("tutorial");
			passwd.sendKeys("tutorial");
			signin.click();
		}
		else
			throw new Exception("Not on the Main Page!");
	}
	
	private WebDriver _driver;
}
