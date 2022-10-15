package exercises.leetcode2001_2200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2172. Maximum AND Sum of Array
 */
public class MaximumAndSumofArray_2172 {
    // dp
    public int maximumANDSum0(int[] nums, int numSlots) {
        int mask = (int) Math.pow(3, numSlots) - 1;
        int[] memo = new int[mask + 1];
        return dp(nums.length - 1, mask, numSlots, memo, nums);
    }

    private int dp(int i, int mask, int numSlots, int[] memo, int[] nums) {
        if (memo[mask] > 0) {
            return memo[mask];
        }
        if (i < 0) {
            return 0;
        }
        for (int slot = 1, bit = 1; slot <= numSlots; ++slot, bit *= 3) {
            if (mask / bit % 3 > 0) {
                memo[mask] = Math.max(memo[mask], (nums[i] & slot) + dp(i - 1, mask - bit, numSlots, memo, nums));
            }
        }
        return memo[mask];
    }

    //dfs
    private final Map<String, Integer> memo = new HashMap<>();

    public int maximumANDSum(int[] nums, int numSlots) {
        int[] slots = new int[numSlots + 1];
        for (int i = 1; i <= numSlots; i++) {
            slots[i] = 2;
        }
        return dfs(nums, slots, 0);
    }

    private int dfs(int[] nums, int[] slots, int indexOfNum) {
        if (indexOfNum == nums.length) {
            return 0;
        }
        String key = Arrays.toString(slots) + "," + indexOfNum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ans = Integer.MIN_VALUE >> 1;
        for (int j = 1; j < slots.length; j++) {
            if (slots[j] == 0) {
                continue;
            }

            slots[j]--;
            ans = Math.max(ans, dfs(nums, slots, indexOfNum + 1) + (nums[indexOfNum] & j));
            slots[j]++;
        }

        memo.put(key, ans);
        return ans;
    }
}
