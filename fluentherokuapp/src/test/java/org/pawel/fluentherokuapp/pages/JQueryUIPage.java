package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-04.
 */
public class JQueryUIPage extends FluentPage {
    @FindBy(linkText = "Menu")
    private FluentWebElement menuLink;

    @Override
    public void isAt() {
        assertThat(menuLink.displayed()).isTrue();
    }

    public void clickMenuLink() {
        menuLink.click();
    }
}
