package contest.biweekly82;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumSumofSquaredDifference {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        PriorityQueue<Integer> diffQueue = new PriorityQueue<>(Collections.reverseOrder());
        long sum =0;

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums2[i] - nums1[i]);
            sum += diff;
            if (diff > 0) {
                diffQueue.offer(Math.abs(nums2[i] - nums1[i]));
            }
        }

        int k = k1 + k2;
        if (sum <= k) {
            return 0;
        }

        while (k > 0 && !diffQueue.isEmpty()) {
            int diff = diffQueue.poll();
            if (diff == 0) {
                return 0;
            }

            int nextDiff = diffQueue.isEmpty() ? 0 : diffQueue.peek();
            int temp = diff - nextDiff + 1;
            if (k >= temp) {
                k -= temp;
                diff -= temp;
            } else {
                diff -= k;
                k = 0;
            }
            if (diff > 0) {
                diffQueue.offer(diff);
            }
        }

        long result = 0;
        while (!diffQueue.isEmpty()) {
            int diff = diffQueue.poll();
            result += (long) diff * diff;
        }
        return result;
    }
}
