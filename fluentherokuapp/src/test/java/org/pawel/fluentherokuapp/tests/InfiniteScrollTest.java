package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.InfiniteScrollPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-02.
 */
public class InfiniteScrollTest extends BaseTest {
    private InfiniteScrollPage infiniteScrollPage;

    @Before
    public void setUp() {
        infiniteScrollPage = goTo(herokuappMainPage).clickInfiniteScrollLink();
        infiniteScrollPage.isAt();
    }

    @Test
    public void testInfiniteScroll() throws Exception {
        int initTextRowsCount = infiniteScrollPage.getTextRowsCount();
        int numberOfNewTextRows = 50;

        for(int i = 0; i < numberOfNewTextRows; i++) {
            infiniteScrollPage.scrollTextRowDown();
        }

        assertThat(infiniteScrollPage.getTextRowsCount()).isEqualTo(initTextRowsCount + numberOfNewTextRows);
    }
}
