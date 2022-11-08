package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CanSumTest {

    @Test
    void testCanSum() {
        assertTrue(CanSum.simple(7, new int[]{2,3}));
        assertFalse(CanSum.simple(7, new int[]{2, 4}));
        assertTrue(CanSum.simple(7, new int[]{5,3,4,7}));
        assertFalse(CanSum.simple(300, new int[]{7, 14}));
    }

    @Test
    void testMemoizedCanSum() {
        assertTrue(CanSum.memoized(7, new int[]{2,3}, new HashMap<Integer, Boolean>()));
        assertFalse(CanSum.memoized(7, new int[]{2, 4}, new HashMap<Integer, Boolean>()));
        assertTrue(CanSum.memoized(7, new int[]{5,3,4,7}, new HashMap<Integer, Boolean>()));
        assertFalse(CanSum.memoized(300, new int[]{7, 14}, new HashMap<Integer, Boolean>()));
    }
}