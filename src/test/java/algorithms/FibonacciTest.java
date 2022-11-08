package algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testFibonacci() {
        assertEquals(8, Fibonacci.simple(6));
        assertEquals(13, Fibonacci.simple(7));
        assertEquals(21, Fibonacci.simple(8));
    }

    @Test
    void testMemoizedFibonacci() {
        var memo = new HashMap<Integer, Long>();

        assertEquals(8, Fibonacci.memoized(6, memo));
        assertEquals(13, Fibonacci.memoized(7, memo));
        assertEquals(21, Fibonacci.memoized(8, memo));
        assertEquals(12586269025L, Fibonacci.memoized(50, memo));
    }
}