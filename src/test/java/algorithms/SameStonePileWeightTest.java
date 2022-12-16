package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SameStonePileWeightTest {

    @Test
    void testHowSum() {
        assertEquals(3, SameStonePileWeight.run(new int[]{5, 8, 13, 27, 14}));
        assertEquals(1, SameStonePileWeight.run(new int[]{5, 8, 13, 27, 14, 1, 1}));
        assertEquals(3, SameStonePileWeight.run(new int[]{1, 2, 3, 9}));
    }
}