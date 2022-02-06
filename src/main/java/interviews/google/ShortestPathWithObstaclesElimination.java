package interviews.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathWithObstaclesElimination {

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dists = new int[m][n][k+1];
        for (int[][] dist : dists)
            for (int[] d : dist)
                Arrays.fill(d, Integer.MAX_VALUE);

        Arrays.fill(dists[0][0], 0);

        // min-heap storing {i, j, # obstacles eliminated, dist}, sorted by distance to (0,0)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        // {x=0, y=0, k = eliminate 0 obstacle, currentDistance}
        heap.offer(new int[]{0, 0, 0, 0});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            if (curr[0] == m-1 && curr[1] == n-1) continue;

            for (int[] dir : DIRECTIONS) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];

                // 1). continue if out of bound
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;

                // 2). continue if out of elimation
                int newK = curr[2] + grid[newX][newY];
                if (newK > k) continue;

                // 3). continue if we have more optimal result
                int newDist = curr[3] + 1;
                if (dists[newX][newY][newK] <= newDist) continue;

                dists[newX][newY][newK] = newDist;
                heap.offer(new int[]{newX, newY, newK, newDist});
            }
        }

        int res = dists[m-1][n-1][0];
        for (int i = 1; i <= k; i++) res = Math.min(res, dists[m-1][n-1][i]);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int shortestPath = Integer.MAX_VALUE;
    private boolean[][] visited;

    public int shortestPath1(int[][] grid, int k) {
        visited = new boolean[grid.length][grid[0].length];
        visit(0, 0, 0, k, grid);
        return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
    }

    private void visit(int currentX, int currentY, int currentSteps, int currentObstacle, int[][] grid) {
        if (currentSteps >= shortestPath || grid.length + grid[0].length - 2 - currentX - currentY + currentSteps >= shortestPath)
            return;

        if (currentX == grid.length - 1 && currentY == grid[0].length - 1) {
            shortestPath = currentSteps;
            return;
        }

        if (currentX + 1 < grid.length && !visited[currentX + 1][currentY]) {
            if (grid[currentX + 1][currentY] != 1) {
                visited[currentX + 1][currentY] = true;
                visit(currentX + 1, currentY, currentSteps + 1, currentObstacle, grid);
                visited[currentX + 1][currentY] = false;
            } else if (currentObstacle > 0){
                visited[currentX + 1][currentY] = true;
                visit(currentX + 1, currentY, currentSteps + 1, currentObstacle - 1, grid);
                visited[currentX + 1][currentY] = false;
            }
        }

        if (currentY + 1 < grid[0].length && !visited[currentX][currentY + 1]) {
            if (grid[currentX][currentY + 1] != 1) {
                visited[currentX][currentY + 1] = true;
                visit(currentX, currentY + 1, currentSteps + 1, currentObstacle, grid);
                visited[currentX][currentY + 1] = false;
            } else if (currentObstacle > 0){
                visited[currentX][currentY + 1] = true;
                visit(currentX, currentY + 1, currentSteps + 1, currentObstacle - 1, grid);
                visited[currentX][currentY + 1] = false;
            }
        }

        if (currentX - 1 >= 0 && !visited[currentX - 1][currentY]) {
            if (grid[currentX - 1][currentY] != 1) {
                visited[currentX - 1][currentY] = true;
                visit(currentX - 1, currentY, currentSteps + 1, currentObstacle, grid);
                visited[currentX - 1][currentY] = false;
            } else if (currentObstacle > 0){
                visited[currentX - 1][currentY] = true;
                visit(currentX - 1, currentY, currentSteps + 1, currentObstacle - 1, grid);
                visited[currentX - 1][currentY] = false;
            }
        }

        if (currentY - 1 >=  0 && !visited[currentX][currentY -1]) {
            if (grid[currentX][currentY -1] != 1) {
                visited[currentX][currentY -1] = true;
                visit(currentX, currentY -1, currentSteps + 1, currentObstacle, grid);
                visited[currentX ][currentY - 1] = false;
            } else if (currentObstacle > 0){
                visited[currentX][currentY - 1] = true;
                visit(currentX, currentY - 1, currentSteps + 1, currentObstacle - 1, grid);
                visited[currentX][currentY - 1] = false;
            }
        }
    }
}
