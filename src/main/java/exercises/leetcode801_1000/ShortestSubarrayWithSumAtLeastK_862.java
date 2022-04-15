package exercises.leetcode801_1000;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK_862 {
    public int shortestSubarray(int[] nums, int k) {
        long[] presum = new long[nums.length + 1];
        int result = Integer.MAX_VALUE;
        presum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        Deque<Integer> monoq = new LinkedList();

        for (int y = 0; y < presum.length; ++y) {
            /**
             * 对于新加入的y，前面的P[?]都要比新加入的P[y]要小，比P[y]大的P[?]都要pop掉，甚至如果都比P[y]大，整个队列都要清空。
             * 为什么？
             * 因为只有比P[y]小的P[?]，才能跟y组成，(y,x)组合，使得P[y]-P[x]>=K。那些不比P[y]小的P[?]，起不到任何作用，不可能存在一个x让当前的y或者之后的新y满足P[y]-P[x]>=K，也就不可能去更新最小长度。因此，只有比 P[y]小的P[?]才有保留的必要。
             */
            while (!monoq.isEmpty() && presum[y] <= presum[monoq.getLast()])
                monoq.removeLast();
            /**
             * 为什么当队列里第一个x满足P[y]-P[x]>=K的时候，第一个x可以被pop掉？
             * 因为此时我们构成了一个P[y]-P[x]>=K，之后这个x就没有作用了。
             * 为什么这个x没有用了？
             * 因为即使之后存在某个其他的y'，也可以跟这个x构成P[y]-P[x]>=K，但是因为y'>y，因此次新的长度一定比当前的长度y-x要长，因为可以不用考虑。
             */
            while (!monoq.isEmpty() && presum[y] >= presum[monoq.getFirst()] + k)
                result = Math.min(result, y - monoq.removeFirst());

            monoq.addLast(y);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int shortestSubarray2(int[] nums, int k) {
        long[] presum = new long[nums.length + 1];
        int result = Integer.MAX_VALUE;
        presum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }

        for (int right = 1; right <= nums.length; right++) {
            for (int left = 0; left < right; left++) {
                if (presum[right] - presum[left] >= k && result > right - left) {
                    result = right - left;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
