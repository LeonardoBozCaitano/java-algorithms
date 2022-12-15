package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatedIntegersTest {

    @Test
    void testDuplicatedIntegers() {
        assertEquals(Arrays.asList(1, 3, 6), DuplicatedIntegers.run(new int[]{1, 2, 3, 6, 3, 6, 1}));
    }
}
