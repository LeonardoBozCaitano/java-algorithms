package algorithms;

public class BinaryGap {

    /**
     * You are given a number, you must see the bigger binary gap that this number has in it's binary representation
     *
     * For example
     * number 1 representation in binary is 1, soo you don't have any 0 char.
     * number 4 representation in binary is 100, soo you 2 zeros, with a gap of 2.
     * number 40 representation in binary is 1000, soo you 2 zeros, with a gap of 3.
     * number 500 representation in binary is 111110100, soo you 3 zeros, with a gap of 2.
     */
    public static int run(int number) {
        String binaryString = Integer.toBinaryString(number);
        int longestBinaryGap = 0;
        int length = binaryString.length();
        char[] charList = binaryString.toCharArray();

        int actualGap = 0;
        for (int i = 0; i < length; i++) {
            if (charList[i] == '0') {
                actualGap += 1;
            } else {
                actualGap = 0;
            }
            if (actualGap > longestBinaryGap) {
                longestBinaryGap = actualGap;
            }
        }

        return longestBinaryGap;
    }
}
