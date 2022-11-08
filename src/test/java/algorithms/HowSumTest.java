package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class HowSumTest {

    @Test
    void testHowSum() {
        assertNotNull(HowSum.simple(7, new int[]{5,3,4,7}));
        assertNull(HowSum.simple(7, new int[]{2, 4}));
        assertNull(HowSum.simple(300, new int[]{7, 14}));
        assertNotNull(HowSum.simple(300, new int[]{2, 7}));
    }

    @Test
    void testHowSumMemoized() {
        assertNotNull(HowSum.memoized(7, new int[]{5,3,4,7}, new HashMap<Integer, int[]>()));
        assertNull(HowSum.memoized(7, new int[]{2, 4}, new HashMap<Integer, int[]>()));
        assertNull(HowSum.memoized(300, new int[]{7, 14}, new HashMap<Integer, int[]>()));
        assertNotNull(HowSum.memoized(300, new int[]{2, 7}, new HashMap<Integer, int[]>()));
    }
}