package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by pawel on 2017-01-16.
 */
public class KeyPressesPage extends FluentPage {
    @FindBy(css = "#result")
    FluentWebElement resultText;

    @Override
    public void isAt() {
        assertThat(find("h3").text()).isEqualTo("Key Presses");
    }

    public String getResultText() {
        await().atMost(2, TimeUnit.SECONDS).ignoring(NotFoundException.class).until(resultText).displayed();

        return resultText.text();
    }
}
