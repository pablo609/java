package lambda3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

public class Exercise1 {
    private List<String> words = Arrays.asList("ala", "ma", "kota", "duzego" , "i", "fajnego");

    @Test
    public void test1() {
        List<String> shortWords = ElementUtils.allMatches(words, s -> s.length() < 4);
        assertThat(shortWords, contains("ala", "ma", "i"));
    }

    @Test
    public void test2() {
        List<String> wordsWithB = ElementUtils.allMatches(words, s -> s.contains("b"));
        assertThat(wordsWithB, empty());
    }

    @Test
    public void test3() {
        List<String> evenLengthWords = ElementUtils.allMatches(words, s -> (s.length() % 2) == 0);
        assertThat(evenLengthWords, containsInAnyOrder("ma", "duzego", "kota"));
    }
}
