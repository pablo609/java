package org.pawel.fluentherokuapp.tests;

import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;
import org.pawel.fluentherokuapp.pages.JQueryUIMenusPage;
import org.pawel.fluentherokuapp.pages.JQueryUIPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-04.
 */
public class JQueryUIMenusTest extends BaseTest {
    private JQueryUIMenusPage jQueryUIMenusPage;

    @Before
    public void setUp() {
        jQueryUIMenusPage = goTo(herokuappMainPage).clickJQueryUIMenusLink();
        jQueryUIMenusPage.isAt();
    }

    @Test
    public void testJQueryUIMenus() throws Exception {
        JQueryUIPage jQueryUIPage;
        jQueryUIPage = jQueryUIMenusPage.clickEnabledMenuItem().clickBackMenuItem();
        jQueryUIPage.isAt();
        jQueryUIPage.clickMenuLink();

        jQueryUIMenusPage.clickEnabledMenuItem().clickDownloadsMenuItem();
        String exceptionMessage = "";
        try {
            jQueryUIMenusPage.clickPdfMenuItem();
        }
        catch(WebDriverException e) {
            exceptionMessage = e.getMessage();
        }
        assertThat(exceptionMessage).contains("Element is not clickable");
    }
}
