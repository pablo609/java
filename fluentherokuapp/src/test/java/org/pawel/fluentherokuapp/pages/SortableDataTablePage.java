package org.pawel.fluentherokuapp.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2017-02-13.
 */
@Wait
public class SortableDataTablePage extends FluentPage {
    @FindBy(css = "#table1 th:nth-of-type(2)")
    private FluentWebElement t1FirstNameHeader;
    @FindBy(css = "#table2 th:nth-of-type(1)")
    private FluentWebElement t2LastNameHeader;
    String t1FirstNameLocator = "#table1 td:nth-of-type(2)";
    String t2LastNameLocator = "#table2 td:nth-of-type(1)";

    @Override
    public void isAt() {
        assertThat(t1FirstNameHeader.displayed()).isTrue();
    }

    public SortableDataTablePage clickT1FirstNameHeader() {
        t1FirstNameHeader.click();

        return this;
    }

    public SortableDataTablePage clickT2LastNameHeader() {
        t2LastNameHeader.click();

        return this;
    }

    public List<String> getT1FirstNameList() {
        return find(t1FirstNameLocator).stream().map(element -> element.text()).collect(Collectors.toList());
    }

    public List<String> getT2LastNameList() {
        return find(t2LastNameLocator).stream().map(element -> element.text()).collect(Collectors.toList());
    }
}
