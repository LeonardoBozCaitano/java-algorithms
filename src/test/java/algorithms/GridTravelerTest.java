package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTravelerTest {

    @Test
    void testGridTraveller() {
        assertEquals(1, GridTraveler.simple(1,1));
        assertEquals(3, GridTraveler.simple(3,2));
        assertEquals(3, GridTraveler.simple(2,3));
        assertEquals(2333606220L, GridTraveler.simple(18,18));
    }

    @Test
    void testMemoizedGridTraveller() {
        var memo = new HashMap<String, Long>();

        assertEquals(1, GridTraveler.memoized(1,1, memo));
        assertEquals(3, GridTraveler.memoized(3,2, memo));
        assertEquals(3, GridTraveler.memoized(2,3, memo));
        assertEquals(2333606220L, GridTraveler.memoized(18,18, memo));
    }
}