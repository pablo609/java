package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.JavaScriptAlertsPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-04.
 */
public class JavaScriptAlertsTest extends BaseTest {
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @Before
    public void setUp() {
        javaScriptAlertsPage = goTo(herokuappMainPage).clickJavaScriptAlertsLink();
        javaScriptAlertsPage.isAt();
    }

    @Test
    public void testJavaScriptAlerts() {
        javaScriptAlertsPage.clickAlertButton().acceptAlert();
        assertThat(javaScriptAlertsPage.getResultText()).isEqualTo("You successfuly clicked an alert");

        javaScriptAlertsPage.clickConfirmButton().dismissAlert();
        assertThat(javaScriptAlertsPage.getResultText()).isEqualTo("You clicked: Cancel");

        String promptText = "AbC1";
        javaScriptAlertsPage.clickPromptButton().fillInPrompt(promptText);
        assertThat(javaScriptAlertsPage.getResultText()).isEqualTo("You entered: " + promptText);
    }
}
