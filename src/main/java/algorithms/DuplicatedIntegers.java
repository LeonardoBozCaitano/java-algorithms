package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, return the duplicated ones
 */
public class DuplicatedIntegers {

    public static List<Integer> run(int[] integers) {
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[i] == (integers[j])) {
                    output.add(integers[i]);
                }
            }
        }

        return output;
    }
}
