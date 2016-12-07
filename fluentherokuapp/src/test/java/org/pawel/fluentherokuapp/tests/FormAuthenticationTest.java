package org.pawel.fluentherokuapp.tests;

import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.FormAuthenticationPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-07.
 */
public class FormAuthenticationTest extends BaseTest {
    private FormAuthenticationPage formAuthenticationPage;
    private final String USER_NAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";

    @Before
    public void setUp() {
        formAuthenticationPage = goTo(herokuappMainPage).clickFormAuthenticationLink();
        formAuthenticationPage.isAt();
    }

    @Test
    public void testPositiveFormAuthentication() throws Exception {
        formAuthenticationPage.setUserName(USER_NAME).setPassword(PASSWORD).clickLogin();

        assertThat(formAuthenticationPage.getMessageText()).contains("You logged into a secure area!");
    }

    @Test
    public void testBadPasswordFormAuthentication() throws Exception {
        formAuthenticationPage.setUserName(USER_NAME).setPassword(PASSWORD+"!").clickLogin();

        assertThat(formAuthenticationPage.getMessageText()).contains("Your password is invalid!");
    }

    @Test
    public void testBadUserFormAuthentication() throws Exception {
        formAuthenticationPage.setUserName(USER_NAME+"a").setPassword(PASSWORD).clickLogin();

        assertThat(formAuthenticationPage.getMessageText()).contains("Your username is invalid!");
    }
}
