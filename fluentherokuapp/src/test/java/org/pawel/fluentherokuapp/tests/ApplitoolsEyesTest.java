package org.pawel.fluentherokuapp.tests;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by pawel on 2017-01-17.
 */
public class ApplitoolsEyesTest {
    private WebDriver driver;
    private Eyes eyes;

    @Before
    public void setUp() {
        eyes = new Eyes();
        eyes.setApiKey("2tHJXOkmRto108KAw1SYtTxZyuMjtHfvQd8XLNQtzMDvI110");

//        System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\chromedriver.exe");
//        driver = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", "C:\\seleniumdrivers\\geckodriver.exe");
        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(dc);

        driver = eyes.open(driver, "fluentherokuapp", "KeyPressesTest", new RectangleSize(1024, 768));

        driver.get("http://the-internet.herokuapp.com/key_presses");
        driver.findElement(By.cssSelector("h3")).click();
    }

    @Test
    public void test() throws Exception {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ENTER);
            eyes.checkWindow("ENTER key");

            robot.keyPress(KeyEvent.VK_R);
            eyes.checkWindow("R key");

            eyes.close();
        }
        finally {
            eyes.abortIfNotClosed();
            driver.close();
        }
    }
}
