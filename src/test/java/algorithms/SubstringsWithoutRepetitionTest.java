package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringsWithoutRepetitionTest {

    @Test
    void testHowSum() {
        assertEquals(4, SubstringsWithoutRepetition.simple("dddd").size());
        assertEquals(2, SubstringsWithoutRepetition.simple("cycle").size());
        assertEquals(2, SubstringsWithoutRepetition.simple("abba").size());
        assertEquals(1, SubstringsWithoutRepetition.simple("asdf").size());
        assertEquals(74, SubstringsWithoutRepetition.simple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaabababababa").size());
    }
}