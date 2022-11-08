package algorithms;

import java.util.Map;

/**
 * The function should return an array containing any combination of the elements thar add up to exactly the targetSim
 * If there is no combination, return null.
 */
public class HowSum {

    /**
     * Time complexity = O(targetSum ^ targetSum.size * targetSum.size)
     * Space complexity = O(targetSum)
     */
    public static int[] simple(int targetSum, int[] numbers) {
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;

        for (int number : numbers) {
            var remainder = targetSum - number;
            var resultArray = simple(remainder, numbers);
            if (resultArray != null) {
                return addTo(number, resultArray);
            }
        }
        return null;
    }

    /**
     * Time complexity = O(targetSum.size * targetSum.size ^ 2)
     * Space complexity = O(targetSum^2)
     */
    public static int[] memoized(int targetSum, int[] numbers, Map<Integer, int[]> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;

        for (int number : numbers) {
            var remainder = targetSum - number;
            var resultArray = memoized(remainder, numbers, memo);
            if (resultArray != null) {
                memo.put(targetSum, addTo(number, resultArray));
                return memo.get(targetSum);
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    public static int[] addTo(int x, int[] array) {
        var newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = x;
        return newArray;
    }
}
