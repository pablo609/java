package lambda4;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise {
    private final List<String> words = Arrays.asList("ala", "mao", "klota", "i klota");

    @Test
    public void firstAllMatch() {
        String result = FunctionUtils.firstAllMatch(words.stream(),
                word -> word.contains("o"),
                word -> word.length() > 4);

        Assertions.assertThat(result).isEqualTo("klota");
    }

    @Test
    public void firstAnyMatch() {
        String result = FunctionUtils.firstAnyMatch(words.stream(),
                word -> word.contains("o"),
                word -> word.length() > 4);

        Assertions.assertThat(result).isEqualTo("mao");
    }
}
