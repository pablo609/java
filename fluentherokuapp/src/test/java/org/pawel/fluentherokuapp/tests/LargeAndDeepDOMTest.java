package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.LargeAndDeepDOMPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-16.
 */
public class LargeAndDeepDOMTest extends BaseTest {
    LargeAndDeepDOMPage largeAndDeepDOMPage;

    @Before
    public void setUp() {
        largeAndDeepDOMPage = goTo(herokuappMainPage).clickLargeAndDeepDOMLink();
        largeAndDeepDOMPage.isAt();
    }

    @Test
    public void testLargeAndDeepDOM() {
        assertThat(largeAndDeepDOMPage.getSiblingText(1, 1)).startsWith("1.1");
        assertThat(largeAndDeepDOMPage.getSiblingText(21, 2)).isEqualTo("21.2");
        assertThat(largeAndDeepDOMPage.getSiblingText(50, 3)).isEqualTo("50.3");

        assertThat(largeAndDeepDOMPage.getTableText(1, 1)).isEqualTo("1.1");
        assertThat(largeAndDeepDOMPage.getTableText(25, 25)).isEqualTo("25.25");
        assertThat(largeAndDeepDOMPage.getTableText(50, 50)).isEqualTo("50.50");
    }
}
