package exercises.leetcode1201_1400;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_1291 {
    /**
     * https://leetcode.com/problems/sequential-digits/discuss/853837/Java-Generating-all-valid-numbers-in-order.-O(1)-space.-No-sorting.-0ms
     * I see that many people have to sort the result in the end. But it is not needed. You can simply generate all valid numbers in order.
     *
     * If you look at provided test cases, you can notice that two consecutive valid numbers always have the similar difference. The difference contains only ones (1).
     * For instance:
     * 23 - 12 = 11
     * 34 -23 = 11
     * ...
     * 234 - 123 = 111
     * 345 - 234 = 111
     * ...
     * 45678 - 34567 = 11111
     *
     * The only exception to this rule is when the number of digits changes: like 89 and 123. But you can see that in this case the first valid number that contains 3 digits (123) is equal to the first valid number that contains 2 digits (12) with appended sequential digit (3). So we can handle this case separately.
     *
     * The solution is simple:
     *
     * Maintain the base , delta (that represent the first valid number containing N digits and a delta containing N ones respectively) and the current number n initially set to base.
     * On each iteration add delta to the current number. If the number of digits changes, change the base and delta and repeat.
     *
     * So, basically the base is changing from : 0 , 1 , 12 , 123 , 1234 ,12345 ....
     * And, the delta changes as : 0 , 1 , 11 , 111 , 1111 , 11111 ....
     * And whenever, we find the increasing numbers in the given range, we add them to the list.
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int base = 0, delta = 0;
        int n = base;
        while (n <= high) {
            if (n >= low) {
                result.add(n);
            }
            n += delta;
            if (n % 10 == 0) { // number of digits changed
                base = base * 10 + (base % 10 + 1);
                delta = delta * 10 + 1;
                n = base;
            }
        }

        return result;
    }
}
