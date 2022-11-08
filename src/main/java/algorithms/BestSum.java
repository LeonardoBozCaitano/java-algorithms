package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * The function should return an array containing the shortest combination of the elements that add up to exactly the targetSim
 * If there is no combination, return null.
 */
public class BestSum {

    /**
     * m = targetSum
     * n = numbers.size
     *
     * Time complexity = O(n ^ m * m)
     * Space complexity = O(m^2)
     */
    public static int[] simple(int targetSum, int[] numbers) {
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;

        int[] shortestArray = null;

        for (int number : numbers) {

            var remainder = targetSum - number;
            var resultArray = simple(remainder, numbers);
            if (resultArray != null && (shortestArray == null || shortestArray.length > resultArray.length)){
                shortestArray = addTo(number, resultArray);
            }
        }
        return shortestArray;
    }

    public static int[] memoized(int targetSum, int[] numbers) {
        return memoized(targetSum, numbers, new HashMap<Integer, int[]>());
    }

    /**
     * Time complexity = O(n * m ^ 2)
     * Space complexity = O(m^2)
     */
    public static int[] memoized(int targetSum, int[] numbers, Map<Integer, int[]> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;

        int[] shortestArray = null;

        for (int number : numbers) {
            var remainder = targetSum - number;
            var resultArray = memoized(remainder, numbers, memo);
            if (resultArray != null && (shortestArray == null || shortestArray.length > resultArray.length)){
                shortestArray = addTo(number, resultArray);
            }
        }
        memo.put(targetSum, shortestArray);
        return shortestArray;
    }

    private static int[] addTo(int x, int[] array) {
        var newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = x;
        return newArray;
    }
}
