package exercises.leetcode201_400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

/**
 * 317. Shortest Distance from All Buildings
 */
public class ShortestDistanceFromAllBuildings_317 {
    public int shortestDistance(int[][] grid) {
        // Next four directions.
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int rows = grid.length;
        int cols = grid[0].length;

        // Total Mtrix to store total distance sum for each empty cell.
        int[][] total = new int[rows][cols];

        int emptyLandValue = 0;
        int minDist = Integer.MAX_VALUE;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {

                // Start a BFS from each house.
                if (grid[row][col] == 1) {
                    minDist = Integer.MAX_VALUE;

                    // Use a queue to perform a BFS, starting from the cell at (r, c).
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{row, col});

                    int steps = 0;

                    while (!q.isEmpty()) {
                        steps++;

                        for (int level = q.size(); level > 0; --level) {
                            int[] curr = q.poll();

                            for (int[] dir : dirs) {
                                int nextRow = curr[0] + dir[0];
                                int nextCol = curr[1] + dir[1];

                                // For each cell with the value equal to empty land value
                                // add distance and decrement the cell value by 1.
                                if (nextRow >= 0 &&
                                    nextRow < rows &&
                                    nextCol >= 0 &&
                                    nextCol < cols &&
                                    grid[nextRow][nextCol] == emptyLandValue) {
                                    grid[nextRow][nextCol]--;
                                    total[nextRow][nextCol] += steps;

                                    q.offer(new int[]{nextRow, nextCol});
                                    minDist = Math.min(minDist, total[nextRow][nextCol]);
                                }
                            }
                        }
                    }

                    // Decrement empty land value to be searched in next iteration.
                    emptyLandValue--;
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static final int[][] DISTANCE = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int nbBuildings;

    public int shortestDistance0(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = Integer.MAX_VALUE;

        for (final int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    nbBuildings++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int distance = buildHouse(grid, min, i, j);
                    if (distance != -1) {
                        min = Math.min(min, distance);
                    } else {
                        fill(grid, i, j);
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void fill(final int[][] grid, final int x, final int y) {
        grid[x][y] = -1;
        for (final int[] direction : DISTANCE) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                fill(grid, newX, newY);
            }
        }
    }

    private int buildHouse(final int[][] grid, final int min, final int x, final int y) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        int countBuildings = 0;
        int countSteps = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[2] > min) {
                return Integer.MAX_VALUE;
            }
            visited.add(new Pair<>(current[0], current[1]));
            for (final int[] direction : DISTANCE) {
                int newX = current[0] + direction[0];
                int newY = current[1] + direction[1];
                if (newX >= 0 &&
                    newX < grid.length &&
                    newY >= 0 &&
                    newY < grid[0].length &&
                    !visited.contains(new Pair<>(newX, newY))) {
                    if (grid[newX][newY] == 1) {
                        countSteps = countSteps + current[2] + 1;
                        visited.add(new Pair<>(newX, newY));
                        countBuildings++;
                        if (countBuildings == nbBuildings) {
                            return countSteps;
                        }
                        continue;
                    }
                    if (grid[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY, current[2] + 1});
                    }
                }
            }
        }
        return -1;
    }

    /*
    private static final int[][] DISTANCE = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private List<int[]> buildingList;

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        buildingList = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingList.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int distance = buildHouse(grid, min, i, j);
                    if (distance != -1) {
                        min = Math.min(min, distance);
                    } else {
                        fill(grid, i, j);
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void fill(final int[][] grid, final int x, final int y) {
        grid[x][y] = -1;
        for (final int[] direction : DISTANCE) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                fill(grid, newX, newY);
            }
        }
    }

    private int buildHouse(final int[][] grid, final int min, final int i, final int j) {
        int sum = 0;
        for (int[] building : buildingList) {
            int distance = calDistance(grid, i, j, building[0], building[1]);
            if (distance == -1) {
                return -1;
            }
            if (sum + distance > min) {
                return Integer.MAX_VALUE;
            }
            sum += distance;
        }
        return sum;
    }

    private int calDistance(final int[][] grid, final int x, final int y, final int p0, final int p1) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == p0 && current[1] == p1) {
                return current[2];
            }
            visited.add(new Pair<>(current[0], current[1]));
            for (final int[] direction : DISTANCE) {
                int newX = current[0] + direction[0];
                int newY = current[1] + direction[1];
                if (newX == p0 && newY == p1) {
                    return current[2] + 1;
                }
                if (newX >= 0 &&
                    newX < grid.length &&
                    newY >= 0 &&
                    newY < grid[0].length &&
                    !visited.contains(new Pair<>(newX, newY)) &&
                    grid[newX][newY] == 0) {
                    queue.offer(new int[]{newX, newY, current[2] + 1});
                }
            }
        }
        return -1;
    }
    */
}
