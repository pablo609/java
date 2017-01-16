package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.pawel.fluentherokuapp.pages.KeyPressesPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-16.
 */
public class KeyPressesTest extends BaseTest {
    private KeyPressesPage keyPressesPage;

    @Before
    public void setUp() {
        keyPressesPage = goTo(herokuappMainPage).clickKeyPressesLink();
        keyPressesPage.isAt();
    }

    @Test
    public void testKeyPresses() {
        keyboard().sendKeys(Keys.ARROW_RIGHT);
        assertThat(keyPressesPage.getResultText()).contains("RIGHT");

        keyboard().sendKeys("A");
        assertThat(keyPressesPage.getResultText()).contains("A");

        keyboard().sendKeys(Keys.ENTER);
        assertThat(keyPressesPage.getResultText()).contains("ENTER");
    }
}
