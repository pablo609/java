package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-08.
 */
@Wait
public class FramesPage extends FluentPage {
    @FindBy(linkText = "Nested Frames")
    private FluentWebElement nestedFramesLink;
    @FindBy(linkText = "iFrame")
    private FluentWebElement iFrameLink;

    @Page
    NestedFramesPage nestedFramesPage;
    @Page
    IFramePage iFramePage;

    @Override
    public void isAt() {
        assertThat(nestedFramesLink.displayed()).isTrue();
    }

    public NestedFramesPage clickNestedFramesLink() {
        nestedFramesLink.click();

        return nestedFramesPage;
    }

    public IFramePage clickIFrameLink() {
        iFrameLink.click();

        return iFramePage;
    }
}
