package contest.biweekly77;

public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long min = Long.MAX_VALUE;
        int result = 0;
        long preSum = 0;
        long postSum = 0;
        for (final int num : nums) {
            postSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            postSum = postSum - nums[i];
            long avgDiff = Math.abs((i != nums.length - 1) ? preSum / (i + 1) - postSum / (nums.length - i - 1) : preSum / (i + 1) - postSum);
            if (avgDiff < min) {
                min = avgDiff;
                result = i;
            }
        }

        return result;
    }
}
