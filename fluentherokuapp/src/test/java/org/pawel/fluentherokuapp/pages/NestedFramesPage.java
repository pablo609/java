package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-08.
 */
@Wait
public class NestedFramesPage extends FluentPage {
    @FindBy(css = "body")
    FluentWebElement frameBody;

    @Override
    public void isAt() {

    }

    public String getTextFromLeftFrame() {
        switchToTopFrame();
        getDriver().switchTo().frame("frame-left");
        return frameBody.text();
    }

    public String getTextFromMiddleFrame() {
        switchToTopFrame();
        getDriver().switchTo().frame("frame-middle");
        return frameBody.text();
    }

    public String getTextFromFrame(String framePosition) {
        if(!framePosition.toLowerCase().equals("bottom"))
            switchToTopFrame();
        getDriver().switchTo().frame("frame-" + framePosition.toLowerCase());
        return frameBody.text();
    }

    private void switchToTopFrame() {
        getDriver().switchTo().frame("frame-top");
    }
}
