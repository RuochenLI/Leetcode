package exercises;

public class PartitionEqualSubsetSum {
    // Similar to https://leetcode.com/problems/last-stone-weight-ii/
    // it can be translated into Knapsack problem => the max sum i can put into half sum
    // dp[i][c] => boolean, if I can sum up to c with first i element
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) return false;

        int half = total / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];
        dp[0][0] = true;
        if (nums[0] <= half) dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= half; j++) {
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[nums.length - 1][half];
    }
}
