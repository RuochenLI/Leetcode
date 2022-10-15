package exercises.leetcode1_200;

/**
 * 45. Jump Game II
 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        int[] jump = new int[nums.length];
        jump[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            jump[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length && jump[i + j] != Integer.MAX_VALUE) {
                    jump[i] = Math.min(jump[i], jump[i + j] + 1);
                }
            }
        }

        return jump[0];
    }
}
