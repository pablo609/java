package lambda1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;

public class Exercise1 {

    private final String[] array = {"ala", "ma", "klota", "1", "e" ,"a"};

    @Test
    public void length() {
        Arrays.sort(array, Comparator.comparing(String::length));

        assertThat(array, arrayContaining("1", "e", "a", "ma", "ala", "klota"));
    }

    @Test
    public void reverseLength() {
        Arrays.sort(array, Comparator.comparing(String::length).reversed());

        assertThat(array, arrayContaining("klota", "ala", "ma", "1", "e", "a"));
    }

    @Test
    public void alphabetically() {
        Arrays.sort(array, Comparator.comparing(s -> s.charAt(0)));

        assertThat(array, arrayContaining("1", "ala", "a", "e", "klota", "ma"));
    }

    @Test
    public void containingE() {
        Arrays.sort(array, Comparator.comparing(s -> {
            return s.contains("e") ? -1 : 1;
        }));

        assertThat(array, arrayContaining("e", "ala", "ma", "klota", "1" ,"a"));
    }
}
