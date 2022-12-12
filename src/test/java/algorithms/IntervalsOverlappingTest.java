package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntervalsOverlappingTest {

    @Test
    void testHowSum() {
        assertArrayEquals(new int[][]{{1,6}, {8,10},{15,18}}, IntervalsOverlapping.run(new int[][]{{1,3}, {2,6}, {8,10},{15,18}}));
        assertArrayEquals(new int[][]{{1,30}}, IntervalsOverlapping.run(new int[][]{{1,10}, {6,15}, {7,30}}));
    }
}