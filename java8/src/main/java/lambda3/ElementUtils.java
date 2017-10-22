package lambda3;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class ElementUtils {
    public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(toList());
    }

    public static <T,R> List<R> transformedList(List<T> list, Function<T,R> function) {
        return list.stream()
                .map(function)
                .collect(toList());
    }
}
