package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BestSumTest {

    @Test
    void testBestSum() {
        assertArrayEquals(new int[]{7}, BestSum.simple(7, new int[]{5,3,4,7}));
        assertArrayEquals(new int[]{3, 5}, BestSum.simple(8, new int[]{2,3,5}));
    }

    @Test
    void testHowSumMemoized() {
        assertArrayEquals(new int[]{7}, BestSum.memoized(7, new int[]{5,3,4,7}));
        assertArrayEquals(new int[]{3, 5}, BestSum.memoized(8, new int[]{2,3,5}));
        assertArrayEquals(new int[]{25, 25, 25, 25}, BestSum.memoized(100, new int[]{1, 2, 25}));
    }
}