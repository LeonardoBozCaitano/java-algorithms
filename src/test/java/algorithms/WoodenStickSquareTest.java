package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WoodenStickSquareTest {

    @Test
    void testHowSum() {
        assertEquals(7, WoodenStickSquare.simple(10,21));
        assertEquals(5, WoodenStickSquare.simple(13,11));
        assertEquals(0, WoodenStickSquare.simple(2,1));
        assertEquals(2, WoodenStickSquare.simple(1,8));
    }
}