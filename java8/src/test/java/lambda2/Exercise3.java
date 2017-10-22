package lambda2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Exercise3 {
    @Test
    public void test1() {
        int x = 0, y =0;
        method1(x, y, Math::cos);
    }

    private void method1(int a, int b, Function<Double, Double> function) {}

    @Test
    public void test2() {
        List<String> someList = new ArrayList<>();
        someList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        int a = 0, b = 0, c = 0;
        method2(a, b, c, Math::pow);
    }

    private <T,U,R> void method2(int a, int b, int c, BiFunction<T,U,R> function) {}

    @Test
    public void test4() {
        Stream<Integer> someStream = new ArrayList<Integer>().stream();
        someStream.reduce(0, Integer::sum);
    }

    @Test
    public void test5() {
        int foo = 0, bar = 0;
        method3(foo, bar, Utils::doSomethingWith);
    }

    private void method3(int foo, int bar, TriFunction function) {}

    @Test
    public void test6() {
        method4(Math::random);
    }

    private <T> void method4(Supplier<T> supplier) {}
}

interface TriFunction {
    boolean apply(int a, int b, int c);
}

class Utils {
    public static boolean doSomethingWith(int a, int b, int c) {
        return true;
    }
}
