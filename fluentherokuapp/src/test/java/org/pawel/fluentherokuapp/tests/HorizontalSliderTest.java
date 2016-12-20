package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.HorizontalSliderPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-20.
 */
public class HorizontalSliderTest extends BaseTest {
    private HorizontalSliderPage horizontalSliderPage;

    @Before
    public void setUp() {
        horizontalSliderPage = goTo(herokuappMainPage).clickHorizontalSliderLink();
        horizontalSliderPage.isAt();
    }

    @Test
    public void testHorizontalSlider() throws Exception {
        horizontalSliderPage.moveSliderRight(3);
        assertThat(horizontalSliderPage.getSliderValue()).isEqualTo(4.0);
    }
}
