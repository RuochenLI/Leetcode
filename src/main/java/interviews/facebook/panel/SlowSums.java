package interviews.facebook.panel;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlowSums {
    /**
     * Slow Sums
     * Suppose we have a list of N numbers, and repeat the following operation until we're left with only a single number: Choose any two numbers and replace them with their sum. Moreover, we associate a penalty with each operation equal to the value of the new number, and call the penalty for the entire list as the sum of the penalties of each operation.
     * For example, given the list [1, 2, 3, 4, 5], we could choose 2 and 3 for the first operation, which would transform the list into [1, 5, 4, 5] and incur a penalty of 5. The goal in this problem is to find the highest possible penalty for a given input.
     * Signature:
     * int getTotalTime(int[] arr)
     * Input:
     * An array arr containing N integers, denoting the numbers in the list.
     * Output format:
     * An int representing the highest possible total penalty.
     * Constraints:
     * 1 ≤ N ≤ 10^6
     * 1 ≤ Ai ≤ 10^7, where *Ai denotes the ith initial element of an array.
     * The sum of values of N over all test cases will not exceed 5 * 10^6.
     * Example
     * arr = [4, 2, 1, 3]
     * output = 26
     * First, add 4 + 3 for a penalty of 7. Now the array is [7, 2, 1]
     * Add 7 + 2 for a penalty of 9. Now the array is [9, 1]
     * Add 9 + 1 for a penalty of 10. The penalties sum to 26.
     */
    int getTotalTime(int[] arr) {
        int penalty = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(arr).forEach(heap::offer);
        for (int num : arr) {
            heap.offer(num);
        }
        while (!heap.isEmpty()) {
            int newPenalty = heap.poll() + heap.poll();
            if (!heap.isEmpty()) heap.offer(newPenalty);
            penalty += newPenalty;
        }

        return penalty;
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
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new SlowSums().run();
    }
}
