package exercises.leetcode601_800;

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargestElementInAStream_703(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else {
            if (heap.peek() < val) {
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();
    }
}
