package exercises.leetcode1201_1400;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 1306. Jump Game III
 */
public class JumpGameIII_1306 {
    // BFS
    public boolean canReach0(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (arr[current] == 0) {
                return true;
            }
            visited.add(current);
            if (current - arr[current] >= 0 && !visited.contains(current - arr[current])) {
                queue.offer(current - arr[current]);
            }
            if (current + arr[current] <= arr.length - 1 && !visited.contains(current + arr[current])) {
                queue.offer(current + arr[current]);
            }
        }
        return false;
    }

    //DFS
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start]; // mark as visited
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}
