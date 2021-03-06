package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-04.
 */

public class JQueryUIMenusPage extends FluentPage {
    @FindBy(css = "#ui-id-2")
    private FluentWebElement enabledMenuItem;
    @FindBy(css = "#ui-id-5")
    private FluentWebElement backMenuItem;
    @FindBy(css = "#ui-id-4")
    private FluentWebElement downloadsMenuItem;
    @FindBy(css = "#ui-id-6")
    private FluentWebElement pdfMenuItem;

    @Page
    JQueryUIPage jQueryUIPage;

    @Override
    public void isAt() {
        assertThat(enabledMenuItem.displayed()).isTrue();
    }

    public JQueryUIMenusPage clickEnabledMenuItem() {
        enabledMenuItem.click();

        return this;
    }

    public JQueryUIPage clickBackMenuItem() {
        backMenuItem.click();

        return jQueryUIPage;
    }

    public JQueryUIMenusPage clickDownloadsMenuItem() {
        downloadsMenuItem.click();

        return this;
    }

    public JQueryUIMenusPage clickPdfMenuItem() {
        pdfMenuItem.click();

        return this;
    }
}
