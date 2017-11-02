package stream1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise {
    private List<String> words = Arrays.asList("hi", "hello", "ala", "john", "bmw");

    @Test
    public void test1() {
        words.forEach(word -> System.out.println("  " + word));
    }

    @Test
    public void test2() {
        words.forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<String> result = words
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Assertions.assertThat(result).containsExactly("HI", "HELLO", "ALA", "JOHN", "BMW");
    }

    @Test
    public void test4() {
        String[] wordsWithO = words
                .stream()
                .filter(word -> word.contains("o"))
                .toArray(String[]::new);

        Assertions.assertThat(wordsWithO).containsExactly("hello", "john");
    }

    @Test
    public void test5() {
        String resultB = capitalizeAndGetFirstWordContaining(words, "B");
        String resultA = capitalizeAndGetFirstWordContaining(words, "A");

        Assertions.assertThat(resultB).isEqualTo("BMW");
        Assertions.assertThat(resultA).isEqualTo("ALA");
    }

    private String capitalizeAndGetFirstWordContaining(List<String> words, String subString) {
        return words
                .stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(word -> word.length() < 4)
                .filter(word -> word.contains(subString))
                .findFirst()
                .orElse(null);
    }
}
