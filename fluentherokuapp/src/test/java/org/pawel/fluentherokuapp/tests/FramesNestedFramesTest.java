package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.pawel.fluentherokuapp.pages.NestedFramesPage;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-01.
 */
@RunWith(Parameterized.class)
public class FramesNestedFramesTest extends BaseTest {
    private NestedFramesPage nestedFramesPage;
    private String framePosition;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {{"LEFT"}, {"MIDDLE"}, {"RIGHT"}, {"BOTTOM"}});
    }

    public FramesNestedFramesTest(String framePosition) {
        this.framePosition = framePosition;
    }

    @Before
    public void setUp() {
        nestedFramesPage = goTo(herokuappMainPage).clickFramesLink().clickNestedFramesLink();
        nestedFramesPage.isAt();
    }

    @Test
    public void testNestedFrames() throws Exception {
        assertThat(nestedFramesPage.getTextFromFrame(framePosition)).isEqualTo(framePosition);
    }
}
