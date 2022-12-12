package algorithms;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Given an array of stone weights, split them into 2 piles with minimal weight difference.
 */
public class IntervalsOverlapping {

    public static int[][] run(int[][] input) {
        int[][] outputIntervals = {};
        for (int[] inputInterval : input) {
            if (outputIntervals.length == 0) {
                outputIntervals = addTo(inputInterval, outputIntervals);
            } else {
                var outputLength = outputIntervals.length;

                for (int j = 0; j < outputLength; j++) {
                    var storedInterval = outputIntervals[j];
                    if (isOverlapping(inputInterval, storedInterval)) {
                        int[] newInterval = {storedInterval[0], inputInterval[1]};
                        outputIntervals[j] = newInterval;
                    } else {
                        outputIntervals = addTo(inputInterval, outputIntervals);
                        break;
                    }
                }
            }
        }

        return outputIntervals;
    }

    private static boolean isOverlapping(int[] input, int[] stored) {
        return (input[0] > stored[0] && input[0] < stored[1]) ||
                (input[1] > stored[0] && input[1] < stored[1]);
    }

    public static int[][] addTo(int[] x, int[][] array) {
        var newArray = new int[array.length + 1][2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = x;
        return newArray;
    }
}
