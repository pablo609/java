package org.pawel.fluentherokuapp.tests;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.HerokuappMainPage;

/**
 * Created by pawel on 2016-12-01.
 */
public class FramesTest extends BaseTest {
    @Test
    public void testFrames() throws Exception {
        goTo(herokuappMainPage).clickFramesLink();

        Thread.sleep(5000);
    }
}
