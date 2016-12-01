package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-01.
 */
public class HerokuappMainPage extends FluentPage {
    @PageUrl("http://the-internet.herokuapp.com/")

    @FindBy(linkText = "Frames") FluentWebElement framesLink;

    @Override
    public void isAt() {
        assertThat(window().title()).isEqualTo("The Internet");
    }
}
