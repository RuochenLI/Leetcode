package exercises.leetcode1801_2000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1834. Single-Threaded CPU
 */
public class SingleThreadedCPU_1834 {
    public int[] getOrder(int[][] tasks) {
        Integer[] indexArr = new Integer[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            indexArr[i] = i;
        }
        Arrays.sort(indexArr, Comparator.comparingInt(index -> tasks[index][0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int intervalA = tasks[a][1];
            int intervalB = tasks[b][1];
            return intervalA == intervalB ? a - b : intervalA - intervalB;
        });
        int pt = 0;
        int time = tasks[indexArr[pt]][0];
        int[] result = new int[tasks.length];
        int count = 0;
        while (pt < tasks.length || !queue.isEmpty()) {
            while (pt < tasks.length && tasks[indexArr[pt]][0] <= time) {
                queue.offer(indexArr[pt]);
                pt++;
            }
            if (!queue.isEmpty()) {
                int runningTaskId = queue.poll();
                result[count++] = runningTaskId;
                time = time + tasks[runningTaskId][1];
            } else {
                time = tasks[indexArr[pt]][0];
            }
        }
        return result;
    }
}
