package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumStringsTest {

    @Test
    void testHowSum() {
        assertEquals(4, MinimumStrings.simple("dddd").size());
        assertEquals(2, MinimumStrings.simple("cycle").size());
        assertEquals(2, MinimumStrings.simple("abba").size());
        assertEquals(1, MinimumStrings.simple("asdf").size());
        assertEquals(74, MinimumStrings.simple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaabababababa").size());
    }
}