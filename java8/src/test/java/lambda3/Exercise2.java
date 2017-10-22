package lambda3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise2 {
    @Test
    public void test1() {
        List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
        List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n > 500);
        assertThat(bigNums).contains(1000, 10000);
    }
}
