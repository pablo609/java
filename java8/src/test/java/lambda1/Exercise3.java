package lambda1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise3 {
    @Test
    public void test1() {
        assertThat(ElementUtils.betterElement(1, 2, (num1, num2) -> num1 > num2)).isEqualTo(2);
    }
}
