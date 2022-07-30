package exercises.leetcode1601_1800;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import javafx.util.Pair;

/**
 * 1631. Path With Minimum Effort
 */
public class PathWithMinimumEffort_1631 {
    public static final int[][] DIRECTION = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // BFS with dij
    public int minimumEffortPath(int[][] heights) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        min = Integer.MAX_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            visited.add(new Pair<>(node[0], node[1]));
            if (node[0] == heights.length - 1 && node[1] == heights[0].length - 1) {
                return node[2];
            }
            for (int[] direction : DIRECTION) {
                int newX = node[0] + direction[0];
                int newY = node[1] + direction[1];
                if (newX >= 0 &&
                    newX < heights.length &&
                    newY >= 0 &&
                    newY < heights[0].length &&
                    Math.abs(heights[newX][newY] - heights[node[0]][node[1]]) < min &&
                    !visited.contains(new Pair<>(newX, newY))) {
                    queue.offer(new int[]{newX, newY, Math.max(node[2],
                                                               Math.abs(heights[newX][newY] -
                                                                        heights[node[0]][node[1]]))});
                }
            }
        }
        return -1;
    }

    // DFS TLE
    int min;

    public int minimumEffortPath0(int[][] heights) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        min = Integer.MAX_VALUE;
        dfs(0, 0, visited, 0, heights);
        return min;
    }

    public void dfs(int x, int y, Set<Pair<Integer, Integer>> visited, int currentDiff, int[][] heights) {
        Pair<Integer, Integer> node = new Pair<>(x, y);
        visited.add(node);
        if (x == heights.length - 1 && y == heights[0].length - 1) {
            min = Math.min(min, currentDiff);
            visited.remove(node);
            return;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] direction : DIRECTION) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 &&
                newX < heights.length &&
                newY >= 0 &&
                newY < heights[0].length &&
                Math.abs(heights[newX][newY] - heights[x][y]) < min &&
                !visited.contains(new Pair<>(newX, newY))) {
                queue.offer(new int[]{newX, newY, Math.abs(heights[newX][newY] - heights[x][y])});
            }
        }

        while (!queue.isEmpty()) {
            int[] input = queue.poll();
            dfs(input[0], input[1], visited, Math.max(currentDiff, input[2]), heights);
        }
        visited.remove(node);
    }
}
