package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.IFramePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-08.
 */
public class FramesIFrameTest extends BaseTest {
    private IFramePage iFramePage;

    @Before
    public void setUp() {
        iFramePage = goTo(herokuappMainPage).clickFramesLink().clickIFrameLink();
        iFramePage.isAt();
    }

    @Test
    public void testIFrame() throws Exception {
        assertThat(iFramePage.getTextFromIFrame()).isEqualTo("Your content goes here.");
    }
}
