package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
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
    @FindBy(linkText = "Geolocation")
    private FluentWebElement geolocationLink;
    @FindBy(linkText = "Horizontal Slider")
    private FluentWebElement horizontalSliderLink;

    @Page
    private FormAuthenticationPage formAuthenticationPage;
    @Page
    private FramesPage framesPage;
    @Page
    private GeolocationPage geolocationPage;
    @Page
    private HorizontalSliderPage horizontalSliderPage;

    @Override
    public void isAt() {
        assertThat(window().title()).isEqualTo("The Internet");
    }

    @Override
    public String getUrl() {
        return "http://the-internet.herokuapp.com/";
    }

    public FramesPage clickFramesLink() {
        framesLink.click();

        return framesPage;
    }

    public FormAuthenticationPage clickFormAuthenticationLink() {
        formAuthenticationLink.click();

        return formAuthenticationPage;
    }

    public GeolocationPage clickGeolocationLink() {
        geolocationLink.click();

        return geolocationPage;
    }

    public HorizontalSliderPage clickHorizontalSliderLink() {
        horizontalSliderLink.click();

        return horizontalSliderPage;
    }
}
