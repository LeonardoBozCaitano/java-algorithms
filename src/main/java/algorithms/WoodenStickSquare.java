package algorithms;

/**
 * There are two wooden sticks of the lengths A and B respectively.
 * Each of them can be but into shorter sticks of integer lengths. Our goal is to construct the largest possible square.
 * In order to do this, we want to vut the sticks in such a way as to achieve four sticks sof the same length.
 * And there can be leftover pieces.
 *
 * What is the longest side of square we can achieve?
 */
public class WoodenStickSquare {

    public static int simple(int A, int B) {
        if (A + B < 4) return 0;
        var biggestNumber = Math.max(A, B);

        for (int i = biggestNumber; i > 0 ; i--) {
            if (calculate(A, B, i)) {
                return i;
            }
        }

        return 0;
    }

    public static boolean calculate(int A, int B, int pieceSize) {
        var divisionA = A / pieceSize;
        var divisionB = B / pieceSize;

        return divisionA + divisionB >= 4;
    }
}
