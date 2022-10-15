package exercises.leetcode1601_1800;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class JumpGameVI_1696 {
    // bruce force O(N^2)
    public int maxResult0(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            score[i] = Integer.MIN_VALUE;
            for (int j = i + 1; j <= Math.min(n -1, i + k); j++) {
                score[i] = Math.max(score[i], nums[i] + score[j]);
            }
        }

        return score[0];
    }

    // PQ O(NlogN)
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int score = nums[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[] { nums[0], 0 });
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (priorityQueue.peek()[1] < i - k) {
                priorityQueue.remove();
            }
            score = nums[i] + priorityQueue.peek()[0];
            priorityQueue.add(new int[] { score, i });
        }
        return score;
    }

    // monotonic queue O(N)
    public int maxResult2(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peek()] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }
}
