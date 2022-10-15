package exercises.leetcode1_200;

/**
 * 55. Jump Game
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        boolean[] jump = new boolean[nums.length];
        jump[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            jump[i] = false;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    jump[i] = jump[i] || jump[i + j];
                }

            }
        }
        return jump[0];
    }

    // greedy O(N)
    public boolean canJump0(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
