package lambda1;

public class StringUtils {
    public static String betterString(String s1, String s2, TwoStringPredicate arbiter) {
        return arbiter.isBetter(s1, s2) ? s1 : s2;
    }
}
