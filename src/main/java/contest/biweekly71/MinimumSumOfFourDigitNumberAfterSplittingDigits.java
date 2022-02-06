package contest.biweekly71;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);
        int num1 = Integer.parseInt(digits[0] + Character.toString(digits[2]));
        int num2 = Integer.parseInt(digits[1] + Character.toString(digits[3]));
        return num1 + num2;
    }
}
