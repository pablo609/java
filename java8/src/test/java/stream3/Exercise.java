package stream3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise {
    List<Double> list;

    @Before
    public void setup() {
        Random rand = new Random();
        list = Stream.generate(rand::nextDouble)
                .limit(100)
                .collect(Collectors.toList());
    }

    @Test
    public void test1() {
        System.out.println(list);
    }

    @Test
    public void test2() {
        Double sum = list
                .parallelStream()
                .mapToDouble(Math::sqrt)
                .sum();

        System.out.println(sum);
    }
}
