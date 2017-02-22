package org.pawel.fluentherokuapp.tests;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pawel.fluentherokuapp.pages.HerokuappMainPage;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.firefox.FirefoxDriver.SystemProperty.BROWSER_PROFILE;

/**
 * Created by pawel on 2016-12-07.
 */
public class BaseTest extends FluentTest {
    @Page
    HerokuappMainPage herokuappMainPage;

    public BaseTest() {
//        setWebDriver("chrome");
//        System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\chromedriver.exe");

//        setWebDriver("firefox");
//        System.setProperty("webdriver.gecko.driver", "C:\\seleniumdrivers\\geckodriver.exe");
//        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
//        DesiredCapabilities dc = DesiredCapabilities.firefox();
//        dc.setCapability(FirefoxDriver.PROFILE, profile);
//        setCapabilities(dc);

        setWebDriver("remote");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setPlatform(Platform.LINUX);
        setCapabilities(capability);
        setRemoteUrl("http://localhost:4444/wd/hub");
    }


}
