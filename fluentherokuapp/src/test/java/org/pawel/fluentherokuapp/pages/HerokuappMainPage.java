package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-01.
 */
public class HerokuappMainPage extends FluentPage {
    @FindBy(linkText = "Form Authentication")
    private FluentWebElement formAuthenticationLink;
    @FindBy(linkText = "Frames")
    private FluentWebElement framesLink;

    @Page
    FormAuthenticationPage formAuthenticationPage;

    @Override
    public void isAt() {
        assertThat(window().title()).isEqualTo("The Internet");
    }

    @Override
    public String getUrl() {
        return "http://the-internet.herokuapp.com/";
    }

    public void clickFramesLink() {
        framesLink.click();
    }

    public FormAuthenticationPage clickFormAuthenticationLink() {
        formAuthenticationLink.click();

        return formAuthenticationPage;
    }
}
