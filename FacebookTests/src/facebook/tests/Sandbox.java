package facebook.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import facebook.util.BrowserFactory;
import facebook.util.FirefoxFactory;

public class Sandbox {
	@Test
	public void testing() throws IOException {
		BrowserFactory factory = new FirefoxFactory();
		WebDriver driver = factory.createWebDriver();
		
		driver.get("https://www.facebook.com/");
		
		Set<Cookie> cookies = driver.manage().getCookies();
		
		for(Cookie cookie : cookies) {
			System.out.println(cookie.toString());
			System.out.println("");
			FileOutputStream fileOut = new FileOutputStream("data\\logoutcookie\\" + cookie.getName() + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cookie);
			out.close();
			fileOut.close();
		}
	}

}
