package hacker.rank;

import java.util.List;

public class plusMinus {
    public static void plusMinus(List<Integer> arr) {
        int numPos = 0;
        int numNeg = 0;
        int numZero = 0;

        for (final Integer num : arr) {
            if (num > 0) numPos++;
            else if (num < 0) numNeg++;
            else numZero++;
        }

        int total = numPos + numNeg + numZero;
        System.out.printf("%.6f\n", (float) numPos / total);
        System.out.printf("%.6f\n", (float) numNeg / total);
        System.out.printf("%.6f\n", (float) numZero / total);
    }
}
