package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.MultipleWindowsPage;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-02-13.
 */
public class MultipleWindowsTest extends BaseTest {
    MultipleWindowsPage multipleWindowsPage;
    String mainWindow;

    @Before
    public void setUp() {
        multipleWindowsPage = goTo(herokuappMainPage).clickMultipleWindowsLink();
        multipleWindowsPage.isAt();
        mainWindow = getDriver().getWindowHandle();
    }

    @Test
    public void testMultipleWindows() throws Exception {
        multipleWindowsPage.clickHere();

        assertThat(window().switchTo(getSecondWindow()).title()).isEqualTo("New Window");
        assertThat(window().switchTo(mainWindow).title()).isEqualTo("The Internet");
    }

    private String getSecondWindow() {
        Set<String> windows = getDriver().getWindowHandles();

        Optional<String> optional = windows.stream().filter(s -> !s.equals(mainWindow)).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }
}
