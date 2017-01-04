package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-04.
 */
public class JavaScriptAlertsPage extends FluentPage {
    @FindBy(css = "li:nth-of-type(1)>button")
    FluentWebElement alertButton;
    @FindBy(css = "li:nth-of-type(2)>button")
    FluentWebElement confirmButton;
    @FindBy(css = "li:nth-of-type(3)>button")
    FluentWebElement promptButton;
    @FindBy(css = "#result")
    FluentWebElement resultText;

    @Override
    public void isAt() {
        assertThat(alertButton.displayed()).isTrue();
    }

    public JavaScriptAlertsPage clickAlertButton() {
        alertButton.click();

        return this;
    }

    public JavaScriptAlertsPage clickConfirmButton() {
        confirmButton.click();

        return this;
    }

    public JavaScriptAlertsPage clickPromptButton() {
        promptButton.click();

        return this;
    }

    public String getResultText() {
        return resultText.text();
    }

    public JavaScriptAlertsPage acceptAlert() {
        alert().accept();

        return this;
    }

    public JavaScriptAlertsPage dismissAlert() {
        alert().dismiss();

        return this;
    }

    public JavaScriptAlertsPage fillInPrompt(String text) {
        alert().prompt(text);

        return this;
    }
}
