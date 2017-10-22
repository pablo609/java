package lambda1;

@FunctionalInterface
public interface TwoStringPredicate {
    boolean isBetter(String s1, String s2);
}
