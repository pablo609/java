package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-20.
 */

@Wait
public class GeolocationPage extends FluentPage {
    @FindBy(css="p#demo+button")
    private FluentWebElement whereIAmButton;

    @Override
    public void isAt() {
        assertThat(whereIAmButton.displayed()).isTrue();
    }

    public GeolocationPage clickWhereIAm() {
        whereIAmButton.click();

        return this;
    }

    public double getLatitude() {
        return Double.parseDouble(find("#lat-value").text());
    }

    public double getLongitude() {
        return Double.parseDouble(find("#long-value").text());
    }
}
