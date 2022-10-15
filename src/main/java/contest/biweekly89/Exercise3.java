package contest.biweekly89;

public class Exercise3 {
    public int minimizeArrayValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        long presum = nums[0];
        int avg = nums[0];

        for (int i = 1; i < nums.length; i++) {
            presum += nums[i];
            if (avg < nums[i]) {
                avg = (int) Math.ceil((double) presum / (i + 1));
            }
            max = Math.max(max, avg);
        }

        return max;
    }
}
