package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-20.
 */
@Wait
public class HorizontalSliderPage extends FluentPage {
    @FindBy(css=".sliderContainer>input")
    FluentWebElement slider;
    @FindBy(css="#range")
    FluentWebElement sliderValue;

    @Override
    public void isAt() {
        assertThat(slider.displayed()).isTrue();
    }

    public HorizontalSliderPage moveSliderRight(int steps) throws AWTException {
        slider.click();

        Robot robot = new Robot();
        for(int i = 0; i < steps; i++) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
        }

        return this;
    }

    public double getSliderValue() {
        return Double.parseDouble(sliderValue.text());
    }
}
