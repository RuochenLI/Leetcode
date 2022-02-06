package interviews.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class MinimizingPermutations {
    /**
     *
     Minimizing Permutations
     In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as (a_1, a_2, ..., a_N). You want to rearrange the elements of the permutation into increasing order, repeatedly making the following operation:
     Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
     Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.
     Signature
     int minOperations(int[] arr)
     Input
     Array arr is a permutation of all integers from 1 to N, N is between 1 and 8
     Output
     An integer denoting the minimum number of operations required to arrange the permutation in increasing order
     Example
     If N = 3, and P = (3, 1, 2), we can do the following operations:
     Select (1, 2) and reverse it: P = (3, 2, 1).
     Select (3, 2, 1) and reverse it: P = (1, 2, 3).
     output = 2
     */

    private int[] swap(final int[] current, int i, int j) {
        int[] newStatus = current.clone();
        newStatus[j] = current[i];
        newStatus[i] = current[j];
        return newStatus;
    }

    private int minOperations(int[] arr) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[] target = IntStream.rangeClosed(1, arr.length).toArray();
        queue.offer(arr);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] current = queue.poll();
                if (Arrays.equals(current, target)) return result;
                for (int i = 0; i < arr.length; i++) {
                    if (current[i] - 1 != i) {
                        for (int j = i + 1; j < arr.length; j++) {
                            if (current[j] - 1 != j) {
                                queue.offer(swap(current, i, j));
                            }
                        }
                    }
                }
            }
            result++;
        }
        return result;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() {

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MinimizingPermutations().run();
    }
}
