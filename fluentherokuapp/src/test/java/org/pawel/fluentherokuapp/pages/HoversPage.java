package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-02.
 */
public class HoversPage extends FramesPage {
    @FindBy(css = ".figure")
    List<FluentWebElement> figures;

    @Override
    public void isAt() {
        assertThat(figures.size()).isGreaterThan(0);
    }

    public String getFigureInfoText(int number) {
        FluentWebElement currentFigure = figures.get(number - 1);
        currentFigure.click();
        await().atMost(5, TimeUnit.SECONDS).ignoring(NotFoundException.class).until(currentFigure.find("h5")).displayed();

        return currentFigure.find("h5").text();
    }
}
