package algorithms;

import java.util.Map;

/**
 * Saying that you are a traveler on a 2d grid, beggining on the top left corner.
 * In how many ways tu can travel to the bottom-right corner?
 *
 * You may use only down or right.
 */
public class GridTraveler {

    /**
     * Time complexity = O(2 ^ n + m)
     * Space complexity = O(n + m)
     */
    public static long simple(int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (n == 1 && m == 1) return 1;
        return simple(n -1, m) + simple(n, m-1);
    }

    /**
     * Time complexity = O(n * m)
     * Space complexity = O(n + m)
     */
    public static long memoized(int n, int m, Map<String, Long> memo) {
        var key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);

        if (n == 0 || m == 0) return 0;
        if (n == 1 && m == 1) return 1;

        memo.put(key, memoized(n - 1, m, memo) + memoized(n, m - 1, memo));
        return memo.get(key);
    }
}
