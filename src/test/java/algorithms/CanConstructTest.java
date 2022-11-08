package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanConstructTest {

    @Test
    void testCanSum() {
        assertTrue(CanConstruct.simple("abcdef", new String[]{"ab","abc", "cd", "ef"}));
        assertFalse(CanConstruct.simple("skateboard", new String[]{"bo","raad", "ate", "ttt", "ska", "bssrs"}));
    }

    @Test
    void testMemoizedCanSum() {
        assertTrue(CanConstruct.memoized("abcdef", new String[]{"ab","abc", "cd", "ef"}));
        assertFalse(CanConstruct.memoized("skateboard", new String[]{"bo","raad", "ate", "ttt", "ska", "bssrs"}));
        assertFalse(CanConstruct.memoized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeexxeeeeefffffaaaaaaaaaaaaaaaaaa",
                new String[]{"e","eeeeee", "aaa", "fff", "dddd", "eeeeeeeeeee", "aaa"})
        );
    }
}