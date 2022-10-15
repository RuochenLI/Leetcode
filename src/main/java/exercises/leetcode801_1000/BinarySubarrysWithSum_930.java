package exercises.leetcode801_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. Binary Subarrays With Sum
 */
public class BinarySubarrysWithSum_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }

        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int x : presum) {
            ans += count.getOrDefault(x, 0);
            count.put(x + goal, count.getOrDefault(x + goal, 0) + 1);
        }

        return ans;
    }

    public int numSubarraysWithSum0(int[] nums, int goal) {
        int right = 0;
        int ans = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            int left = 0;
            int leftSum = sum;
            while (left <= right && leftSum >= goal) {
                if (leftSum == goal) {
                    ans++;
                }
                leftSum -= nums[left];
                left++;
            }
            right++;
        }
        return ans;
    }
}
