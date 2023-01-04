package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryGapTest {

    @Test
    void testBinaryGap() {
        assertEquals(0, BinaryGap.run(1));
        assertEquals(2, BinaryGap.run(4));
        assertEquals(2, BinaryGap.run(500));
        assertEquals(2, BinaryGap.run(444));
        assertEquals(3, BinaryGap.run(40));
        assertEquals(1, BinaryGap.run(2));
    }
}