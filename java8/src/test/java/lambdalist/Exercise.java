package lambdalist;

import org.junit.Test;

import java.util.List;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.toList;

public class Exercise {
    @Test
    public void test() {
        long size = 10;
        List<Double> list = DoubleStream
                .generate(Math::random)
                .limit(size)
                .boxed()
                .collect(toList());

        System.out.println(list);

        double avg = list.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        System.out.println(avg);

        List<Double> copy = list.stream().collect(toList());

        copy.removeIf(num -> num > 0.7);

        System.out.println(copy);

        copy.replaceAll(num -> num * 2.0);

        System.out.println(copy);
    }


}
