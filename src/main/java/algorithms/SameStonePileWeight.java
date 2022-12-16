package algorithms;

/**
 * Given an array of stone weights, split them into 2 piles with minimal weight difference.
 */
public class SameStonePileWeight {

    public static Integer run(int[] stones) {
        long minimalWeithDifference = Long.MAX_VALUE;

        for (int n = 0; n < (1 << (stones.length + 1)); n++) {
            long weightLeft = 0;
            long weightRight = 0;
            for (int bit = 0; bit < stones.length; bit++) {
                boolean isSet = (n & (1 << bit)) > 0;
                if (isSet) {
                    weightLeft += stones[bit];
                } else {
                    weightRight += stones[bit];
                }
            }

            long actualDifference = Math.abs(weightLeft - weightRight);
            if (actualDifference < minimalWeithDifference) {
                minimalWeithDifference = actualDifference;
            }
        }

        return (int) minimalWeithDifference;
    }
}
