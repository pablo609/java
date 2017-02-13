package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.SortableDataTablePage;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-02-13.
 */
public class SortableDataTableTest extends BaseTest {
    private SortableDataTablePage sortableDataTablePage;

    @Before
    public void setUp() {
        sortableDataTablePage = goTo(herokuappMainPage).clickSortableDataTableLink();
        sortableDataTablePage.isAt();
    }

    @Test
    public void testSortableDataTable() {
        assertThat(sortableDataTablePage.clickT1FirstNameHeader().getT1FirstNameList()).isSorted();
        assertThat(sortableDataTablePage.clickT2LastNameHeader().getT2LastNameList()).isSorted();
    }
}
