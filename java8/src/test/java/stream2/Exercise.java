package stream2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise {
    private List<String> words = Arrays.asList("hi", "hello", "ala", "john", "bmw");

    @Test
    public void test1() {
        String sentence = words
                .stream()
                .reduce("", (s1, s2) -> s1 + s2.toUpperCase());

        assertThat(sentence).isEqualTo("HIHELLOALAJOHNBMW");
    }

    @Test
    public void test2() {
        String sentence = words
                .stream()
                .map(String::toUpperCase)
                .reduce("", (s1, s2) -> s1 + s2);

        assertThat(sentence).isEqualTo("HIHELLOALAJOHNBMW");
    }

    @Test
    public void test3() {
        String sentence = words
                .stream()
                .reduce((s1, s2) -> s1 + "," + s2)
                .orElse("");

        assertThat(sentence).isEqualTo("hi,hello,ala,john,bmw");
    }

    @Test
    public void test4() {
        int length = words
                .stream()
                .mapToInt(String::length)
                .sum();

        assertThat(length).isEqualTo(17);
    }

    @Test
    public void test5() {
        long number = words
                .stream()
                .filter(s -> s.contains("h"))
                .count();

        assertThat(number).isEqualTo(3);
    }
}
