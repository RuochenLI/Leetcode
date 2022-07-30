package exercises.leetcode1201_1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1218. Longest Arithmetic Subsequence of Given Difference
 */
public class LongestArithmeticSubsequenceOfGivenDifference_1218 {
    public int longestSubsequence0(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        Map<Integer, Integer> diffMap = new HashMap<>();
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (diffMap.containsKey(arr[i] + difference)) {
                dp[i] = Math.max(dp[i], diffMap.get(arr[i] + difference) + 1);
            }
            diffMap.put(arr[i], Math.max(dp[i], diffMap.getOrDefault(arr[i], 0)));
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for (final int j : arr) {
            dp.put(j, dp.getOrDefault(j - difference, 0) + 1);
            longest = Math.max(longest, dp.get(j));
        }
        return longest;
    }
}
