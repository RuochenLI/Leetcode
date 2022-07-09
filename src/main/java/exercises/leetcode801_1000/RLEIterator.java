package exercises.leetcode801_1000;

import java.util.LinkedList;

/**
 * 900. RLE Iterator
 */
public class RLEIterator {
    private LinkedList<int[]> queue;

    public RLEIterator(int[] encoding) {
        this.queue = new LinkedList<>();
        int pt = 0;
        while (pt < encoding.length) {
            int occ = encoding[pt];
            int num = encoding[++pt];

            if (occ > 0) {
                this.queue.offer(new int[]{num, occ});
            }

            pt++;
        }
    }

    public int next(int n) {
        int count = n;
        while (!this.queue.isEmpty() && this.queue.peek()[1] < count) {
            int[] encoding = this.queue.poll();
            count -= encoding[1];
        }
        if (this.queue.isEmpty()) {
            return -1;
        }

        this.queue.peek()[1] = this.queue.peek()[1] - count;
        return this.queue.peek()[0];
    }

    /**
     *     int[] arr;
     *     int idx;
     *     public RLEIterator(int[] A) {
     *         this.arr = A;
     *         idx = 0;
     *     }
     *
     *     public int next(int n) {
     *         while (idx < arr.length) {
     *             if (n > arr[idx]) {
     *                 n -= arr[idx];
     *                 idx += 2;
     *             } else {
     *                 arr[idx] -= n;
     *                 return arr[idx + 1];
     *             }
     *         }
     *         return -1;
     *     }
     */
}
