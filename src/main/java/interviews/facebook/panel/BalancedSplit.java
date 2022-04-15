package interviews.facebook.panel;

import java.util.Arrays;

public class BalancedSplit {
    // todo: review
    /**
     * Balanced Split
     * Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
     * Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
     * Signature
     * bool balancedSplitExists(int[] arr)
     * Input
     * All integers in array are in the range [0, 1,000,000,000].
     * Output
     * Return true if such a split is possible, and false otherwise.
     * Example 1
     * arr = [1, 5, 7, 1]
     * output = true
     * We can split the array into A = [1, 1, 5] and B = [7].
     * Example 2
     * arr = [12, 7, 6, 7, 6]
     * output = false
     * We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all integers in A are smaller than all integers in B.
     * @param arr
     * @param i1
     * @param i2
     */
    void swap (int[] arr, int i1, int i2) {
        if (i1 == i2) {
            return;
        }

        int t = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = t;
    }

    boolean partitionSum(int[] arr, int start, int end, int currSum, int neededSum) {
        if (start == end) {
            return currSum + arr[start] == neededSum;
        }

        int newSum = currSum;
        int lowerBound = start;

        for (int upperBound = start; upperBound < end; ++upperBound) {
            if (arr[upperBound] <= arr[end]) {
                newSum += arr[upperBound];
                swap(arr, lowerBound++, upperBound);
            }
        }

        swap(arr, lowerBound, end);
        newSum += arr[lowerBound];

        if (newSum < neededSum) {
            return partitionSum(arr, lowerBound + 1, end, newSum, neededSum);
        }

        if (newSum > neededSum) {
            while (lowerBound >= start && (arr[lowerBound] == arr[end])) {
                --lowerBound;
            }

            if (lowerBound <= start) {
                return false;
            }

            return partitionSum(arr, start, lowerBound, currSum, neededSum);
        }

        return true;
    }

    boolean balancedSplitExists(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        if (sum % 2 != 0) {
            return false;
        }

        return partitionSum(arr, 0, arr.length - 1, 0, sum / 2);
    }

//    boolean balancedSplitExists(int[] arr) {
//        int sum = 0;
//        for (int num : arr) {
//            sum += num;
//        }
//
//        if (sum % 2 != 0) return false;
//
//        int half = sum / 2;
//        boolean[][] dp = new boolean[arr.length][half + 1];
//        for (int i = 0; i < arr.length; i++){
//            dp[i][0] = true;
//        }
//        dp[0][arr[0]] = true;
//        for (int i = 1; i < arr.length; i++){
//            for (int j = 1; j <= half; j++) {
//                if (j >= arr[i]) {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[arr.length - 1][half];
//    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalancedSplit().run();
    }
}
