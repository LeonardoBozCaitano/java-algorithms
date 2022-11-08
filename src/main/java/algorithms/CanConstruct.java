package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * The function should return a boolean indicating whether or not it is possible to generate
 * the targetWord using strings from the array.
 */
public class CanConstruct {

    /**
     * m = targetWord
     * n = wordBank.length
     *
     * Time complexity = 0(n ^ m + m)
     * Space complexity = O(m²)
     */
    public static boolean simple(String targetWord, String[] workBank) {
        if (targetWord.isBlank()) return true;

        for (String word : workBank) {
            if (targetWord.indexOf(word) == 0) {
                var suffix = targetWord.substring(word.length());
                if (simple(suffix, workBank)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean memoized(String targetWord, String[] workBank) {
        return memoized(targetWord, workBank, new HashMap<>());
    }

    /**
     * Time complexity = O(n * m)
     * Space complexity = O(m)
     */
    public static boolean memoized(String targetWord, String[] workBank, Map<String, Boolean> memo) {
        if (memo.containsKey(targetWord)) return memo.get(targetWord);
        if (targetWord.isBlank()) return true;

        for (String word : workBank) {
            if (targetWord.indexOf(word) == 0) {
                var suffix = targetWord.substring(word.length());
                if (simple(suffix, workBank)) {
                    return true;
                }
            }
        }

        memo.put(targetWord, false);
        return false;
    }
}
