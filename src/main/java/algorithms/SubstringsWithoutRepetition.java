package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given a string consisting of lowercase letters of the English alphabet.
 * You must split this into a minimal number of substrings in such a way that no letter occurs more than once in each substring.
 *
 * For example, here are some correct splits of the string "abacdec":
 * ('a', 'bac', 'dec')
 * ('a', 'bacd', 'ec')
 */
public class SubstringsWithoutRepetition {

    public static List<String> simple(String string) {
        if (string.isBlank()) return null;

        var stringArray = string.toCharArray();
        var validatedStringArray = new ArrayList<>();

        for (int i = 0; i < stringArray.length; i++) {
            if (!validatedStringArray.contains(stringArray[i])) {
                validatedStringArray.add(stringArray[i]);
            } else {
                var foundArray = new ArrayList<>(Collections.singletonList(string.substring(0, i - 1)));
                var cleanedString = string.substring(i);
                var childrenResult = simple(cleanedString);
                foundArray.addAll(childrenResult);
                return foundArray;
            }
        }

        return Collections.singletonList(string);
    }
}
