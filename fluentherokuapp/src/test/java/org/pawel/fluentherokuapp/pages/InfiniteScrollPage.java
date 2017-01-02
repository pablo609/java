package org.pawel.fluentherokuapp.pages;

import org.openqa.selenium.TimeoutException;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-02.
 */
public class InfiniteScrollPage extends FramesPage {
    private String textRowLocator = ".jscroll-added";

    @Override
    public void isAt() {
        int initTextRowsCount = getTextRowsCount();

        assertThat(initTextRowsCount).isGreaterThan(0);

        await().atMost(2, TimeUnit.SECONDS).ignoring(TimeoutException.class).until(find(textRowLocator)).size().greaterThan(initTextRowsCount);
    }

    public InfiniteScrollPage scrollTextRowDown() {
        int initTextRowsCount = getTextRowsCount();

        find(textRowLocator).get(getTextRowsCount() - 1).scrollIntoView(false);

        await().atMost(2, TimeUnit.SECONDS).until(find(textRowLocator)).size().greaterThan(initTextRowsCount);

        return this;
    }

    public int getTextRowsCount() {
        return find(textRowLocator).size();
    }
}
