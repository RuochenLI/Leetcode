package exercises;

public class ProductOfArrayExcepSelf {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean zero = false;
        int numZero = 0;
        int[] ans = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                zero = true;
                numZero++;
            } else {
                product = product * num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero) {
                if (nums[i] == 0 && numZero == 1) {
                    ans[i] = product;
                }

            } else {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, prefix = 1; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1, postfix = 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }

}
