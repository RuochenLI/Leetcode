package exercises;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int subsum = 0;
        for (final int item : nums) {
            subsum = item + Math.max(subsum, 0);
            max = Math.max(subsum, max);
        }

        return max;
    }
}
