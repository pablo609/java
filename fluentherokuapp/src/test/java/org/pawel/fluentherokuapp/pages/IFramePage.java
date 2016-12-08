package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pawel on 2016-12-08.
 */
public class IFramePage extends FluentPage {
    @FindBy(css = "#tinymce")
    private FluentWebElement frameBody;

    public String getTextFromIFrame() {
        switchTo(find("iframe#mce_0_ifr"));
        return frameBody.text();
    }
}
