package interviews.google;

import java.util.Stack;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        Stack<Integer> ansStack = new Stack<>();
        int plusOne = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            int tmp = digits[i] + plusOne;
            ansStack.push(tmp % 10);
            plusOne = tmp / 10;
        }
        if (plusOne != 0){
            ansStack.push(plusOne);
        }
        int[] ans = new int[ansStack.size()];
        int pointer = 0;
        while (!ansStack.empty()) {
            ans[pointer++] = ansStack.pop();
        }
        return ans;
    }

    /**
     * 1. the input won't have zero at digits[0] as it's not valid to have a number's most significant number to be a zero.
     *
     * 2. if the resulting digits[0] is zero, then all its trailing digits must be zeroes too. Thus we don't need to assign digits[] to res[i] to res[len+1].
     *
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne1(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;

        return ret;
    }
}
