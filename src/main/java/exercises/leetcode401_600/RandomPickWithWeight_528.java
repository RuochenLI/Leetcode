package exercises.leetcode401_600;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight_528 {
    class Solution {
        int sum;
        Random random;
        int[] presum;
        public Solution(int[] w) {
            this.sum = 0;
            this.presum = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                this.sum += w[i];
                this.presum[i] = this.sum;
            }
            this.random = new Random();
        }

        public int pickIndex() {
            int low = 0;
            int high = this.presum.length;
            int target = this.random.nextInt(sum) + 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (presum[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

//        TreeMap<Integer, Integer> map;
//        public Solution(int[] w) {
//            this.sum = 0;
//            this.map = new TreeMap<>();
//            for (int i = 0; i < w.length; i++) {
//                this.sum += w[i];
//                this.map.put(this.sum, i);
//            }
//            this.random = new Random();
//        }
//
//        public int pickIndex() {
//            Map.Entry<Integer, Integer> indexEntry = this.map.higherEntry(this.random.nextInt(sum));
//            return indexEntry == null ? 0 : indexEntry.getValue();
//        }
    }
}
