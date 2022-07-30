package exercises.leetcode1201_1400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 1331. Rank Transform of an Array
 */
public class RankTransformOfAnArray_1331 {
    public int[] arrayRankTransform0(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> arr[a]));
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            queue.offer(i);
        }
        int count = 0;
        int prev = -1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (arr[current] != prev) {
                count++;
                result[current] = count;
                prev = arr[current];
            } else {
                result[current] = count;
            }
        }
        return result;
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int num : result) {
            rank.putIfAbsent(num, rank.size() + 1);
        }
        for (int i = 0; i < arr.length; ++i) {
            result[i] = rank.get(arr[i]);
        }
        return result;
    }
}
