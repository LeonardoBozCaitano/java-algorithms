package algorithms;

import java.util.Map;

/**
 * The function should return the n-th number of the Fibonacci sequence.
 *
 * The 1st and 2nd number of the sequence is 1.
 * To generate the next number of the sequence, we sum the previous two.
 */
public class Fibonacci {

    /**
     * Time complexity = O(2 ^ n)
     * Space complexity = O(2)
     */
    public static int simple(int n) {
        if (n <= 2) return 1;
        return simple(n-1) + simple(n-2);
    }

    /**
     * Time complexity = O(n)
     * Space complexity = O(n)
     */
    public static long memoized(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        var result = memoized(n-1, memo) + memoized(n-2, memo);
        memo.put(n, result);
        return memo.get(n);
    }
}
