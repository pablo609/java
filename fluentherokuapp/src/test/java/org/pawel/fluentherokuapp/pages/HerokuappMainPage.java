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
    @FindBy(linkText = "Hovers")
    private FluentWebElement hoversLink;
    @FindBy(linkText = "Infinite Scroll")
    private FluentWebElement infiniteScrollLink;
    @FindBy(linkText = "JQuery UI Menus")
    private FluentWebElement jQueryUIMenusLink;
    @FindBy(linkText = "JavaScript Alerts")
    private FluentWebElement javaScriptAlertsLink;
    @FindBy(linkText = "Key Presses")
    private FluentWebElement keyPressesLink;
    @FindBy(linkText = "Large & Deep DOM")
    private FluentWebElement largeAndDeepDOMLink;
    @FindBy(linkText = "Multiple Windows")
    private FluentWebElement multipleWindowsLink;
    @FindBy(linkText = "Sortable Data Tables")
    private FluentWebElement sortableDataTablesLink;

    @Page
    private FormAuthenticationPage formAuthenticationPage;
    @Page
    private FramesPage framesPage;
    @Page
    private GeolocationPage geolocationPage;
    @Page
    private HorizontalSliderPage horizontalSliderPage;
    @Page
    private HoversPage hoversPagePage;
    @Page
    private InfiniteScrollPage infiniteScrollPage;
    @Page
    private JQueryUIMenusPage jQueryUIMenusPage;
    @Page
    private JavaScriptAlertsPage javaScriptAlertsPage;
    @Page
    private KeyPressesPage keyPressesPage;
    @Page
    private LargeAndDeepDOMPage largeAndDeepDOMPage;
    @Page
    private MultipleWindowsPage multipleWindowsPage;
    @Page
    private SortableDataTablePage sortableDataTablePage;

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

    public HoversPage clickHoversLink() {
        hoversLink.click();

        return hoversPagePage;
    }

    public InfiniteScrollPage clickInfiniteScrollLink() {
        infiniteScrollLink.click();

        return infiniteScrollPage;
    }

    public JQueryUIMenusPage clickJQueryUIMenusLink() {
        jQueryUIMenusLink.click();

        return jQueryUIMenusPage;
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        javaScriptAlertsLink.click();

        return javaScriptAlertsPage;
    }

    public KeyPressesPage clickKeyPressesLink() {
        keyPressesLink.click();

        return keyPressesPage;
    }

    public LargeAndDeepDOMPage clickLargeAndDeepDOMLink() {
        largeAndDeepDOMLink.click();

        return largeAndDeepDOMPage;
    }

    public MultipleWindowsPage clickMultipleWindowsLink() {
        multipleWindowsLink.click();

        return multipleWindowsPage;
    }

    public SortableDataTablePage clickSortableDataTableLink() {
        sortableDataTablesLink.click();

        return sortableDataTablePage;
    }
}
