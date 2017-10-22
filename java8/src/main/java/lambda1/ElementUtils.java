package lambda1;

public class ElementUtils {
    public static <T> T betterElement(T element1, T element2, TwoElementPredicate<T> arbiter) {
        return arbiter.isBetter(element1, element2) ? element1 : element2;
    }
}
