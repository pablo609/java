package org.pawel.fluentherokuapp.tests;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.pawel.fluentherokuapp.pages.HerokuappMainPage;

/**
 * Created by pawel on 2016-12-07.
 */
public class BaseTest extends FluentTest {
    @Page
    HerokuappMainPage herokuappMainPage;

    public BaseTest() {
        setWebDriver("chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumdrivers\\chromedriver.exe");

    }
}
