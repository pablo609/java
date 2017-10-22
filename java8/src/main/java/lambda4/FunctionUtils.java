package lambda4;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionUtils {
    private static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates) {
        return t -> countMatchingPredicates(t, predicates) == predicates.length;
    }

    private static <T> long countMatchingPredicates(T t, Predicate<T>[] predicates) {
        return Arrays.asList(predicates)
                .stream()
                .filter(p -> p.test(t))
                .count();
    }

    private static <T> Predicate<T> anyPassPredicate(Predicate<T>... predicates) {
        return t -> countMatchingPredicates(t, predicates) > 0;
    }

    public static <T> T firstAllMatch(Stream<T> stream, Predicate<T>... predicates) {
        return stream
                .filter(allPassPredicate(predicates))
                .findFirst()
                .orElse(null);
    }

    public static <T> T firstAnyMatch(Stream<T> stream, Predicate<T>... predicates) {
        return stream
                .filter(anyPassPredicate(predicates))
                .findFirst()
                .orElse(null);
    }
}
