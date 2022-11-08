package algorithms;

import java.util.Map;

/**
 * The function should return a boolean indicating whether or not it is possible to generate
 * the targetSum using numbers from the array.
 */
public class CanSum {

    /**
     * Time complexity = 0 (n ^ m)
     * Space complexity = O(m)
     */
    public static boolean simple(int targetSum, int[] numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int number : numbers) {
            var remainder = targetSum - number;
            if (simple(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Time complexity = O(n * m)
     * Space complexity = O(m)
     */
    public static boolean memoized(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int number : numbers) {
            var remainder = targetSum - number;
            if (memoized(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }
}
