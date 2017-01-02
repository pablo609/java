package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.HoversPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-02.
 */
public class HoversTest extends BaseTest {
    private HoversPage hoversPage;

    @Before
    public void setUp() {
        hoversPage = goTo(herokuappMainPage).clickHoversLink();
        hoversPage.isAt();
    }

    @Test
    public void testFigures() throws Exception {
        for(int i = 1; i <= 3; i++)
            assertThat(hoversPage.getFigureInfoText(i)).isEqualTo("name: user" + i);
    }
}
