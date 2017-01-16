package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-01-16.
 */
public class LargeAndDeepDOMPage extends FluentPage {
    @Override
    public void isAt() {
        assertThat(find("h3").text()).isEqualTo("Large & Deep DOM");
    }

    public String getSiblingText(int level, int element) {
        return find(".tier-" + Integer.toString(level) + ".item-" + Integer.toString(element)).text();
    }

    public String getTableText(int row, int column) {
        return find(".row-" + Integer.toString(row) + " > .column-" + Integer.toString(column)).text();
    }
}
