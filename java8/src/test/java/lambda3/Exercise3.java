package lambda3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise3 {
    List<String> words = Arrays.asList("ala", "ma", "kota", "duzego" , "i", "fajnego");
    @Test
    public void test1() {
       List<String> excitingWords = ElementUtils.transformedList(words, s -> s + "!");
        assertThat(excitingWords).containsExactly("ala!", "ma!", "kota!", "duzego!" , "i!", "fajnego!");
    }

    @Test
    public void test2() {
        List<Integer> wordLengths = ElementUtils.transformedList(words, String::length);
        assertThat(wordLengths).containsExactly(3, 2, 4, 6, 1, 7);
    }
}
