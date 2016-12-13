package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-07.
 */
@Wait
public class FormAuthenticationPage extends FluentPage {
    @FindBy(css = "#username")
    private FluentWebElement userNameInput;
    @FindBy(css = "#password")
    private FluentWebElement passwordInput;
    @FindBy(css = "button.radius")
    private FluentWebElement loginButton;
    @FindBy(css = "#flash")
    private FluentWebElement messageText;


    @Override
    public void isAt() {
        assertThat(userNameInput.displayed()).isTrue();
    }

    public FormAuthenticationPage setUserName(String text) {
        userNameInput.write(text);

        return this;
    }

    public FormAuthenticationPage setPassword(String text) {
        passwordInput.write(text);

        return this;
    }

    public FormAuthenticationPage clickLogin() {
        loginButton.click();

        return this;
    }

    public String getMessageText() {
        return messageText.text();
    }
}
