package lambda1;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Exercise2 {
    @Test
    public void test1() {
        assertThat(StringUtils.betterString("mysz", "klot", (s1, s2) -> !s2.contains("k")), equalTo("klot"));
    }
}
