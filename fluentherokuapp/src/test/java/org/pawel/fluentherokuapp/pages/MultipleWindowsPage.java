package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-02-13.
 */
@Wait
public class MultipleWindowsPage extends FluentPage {
    @FindBy(linkText = "Click Here")
    private FluentWebElement clickHereLink;

    @Override
    public void isAt() {
        assertThat(clickHereLink.displayed()).isTrue();
    }

    public MultipleWindowsPage clickHere() {
        clickHereLink.click();

        return this;
    }
}
