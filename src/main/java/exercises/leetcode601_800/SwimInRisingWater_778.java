package exercises.leetcode601_800;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * 778. Swim in Rising Water
 */
public class SwimInRisingWater_778 {
    private static final int[][] DICT = {{0,1},{0,-1},{1,0},{-1,0}};

    // Heap
    public int swimInWater0(int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(k -> grid[k / N][k % N]));
        pq.offer(0);
        int ans = 0;

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int r = k / N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N - 1 && c == N - 1) {
                return ans;
            }

            for (int i = 0; i < 4; ++i) {
                int cr = r + DICT[i][0], cc = c + DICT[i][1];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
                    pq.offer(ck);
                    seen.add(ck);
                }
            }
        }

        return -1;
    }

    /**
     * Binary Search and DFS
     *
     * Whether the swim is possible is a monotone function with respect to time, so we can binary search this function for the correct time: the smallest T for which the swim is possible.
     *
     * Say we guess that the correct time is T. To check whether it is possible, we perform a simple depth-first search where we can only walk in squares that are at most T.
     */
    public int swimInWater1(int[][] grid) {
        int N = grid.length;
        int lo = grid[0][0], hi = N * N;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!possible(mi, grid)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public boolean possible(int T, int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        Stack<Integer> stack = new Stack();
        stack.add(0);

        while (!stack.empty()) {
            int k = stack.pop();
            int r = k / N, c = k % N;
            if (r == N-1 && c == N-1) return true;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;
                if (0 <= cr && cr < N && 0 <= cc && cc < N
                    && !seen.contains(ck) && grid[cr][cc] <= T) {
                    stack.add(ck);
                    seen.add(ck);
                }
            }
        }

        return false;
    }

    /**
     * Union find
     * Essentially, the algorithm can be implemented with two major functions: union(a, b) and find(a). With the union(a, b) function, we merge two sets together. And with the find(a) function, we find the representative (also known as parent) of the set.
     *
     * Here are some overall steps of an adapted Kruskal's algorithm:
     *
     * We consider each cell in the grid as a node in a graph, and the value in the cell represents its weight.
     *
     * We then sort the cells based on their weights, in the ascending order.
     *
     * We then iterate through the sorted cells.
     *
     * At each iteration, we add the neighbor cells around the current cell to the spanning tree.
     *
     * At any moment, if we find that the starting and ending points are connected thanks to the newly added nodes, we exit the loop. And the weight of the current cell would be the minimal waiting time, before we complete the spanning tree.
     */

//    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//    private int[] parents;
//
//    private void buildUnionFind(int rows, int cols) {
//        parents = new int[rows * cols];
//
//        for (int i = 0; i < parents.length; ++i) {
//            parents[i] = i;
//        }
//    }
//
//    private int find(int id) {
//        while (id != parents[id]) {
//            parents[id] = parents[parents[id]];
//            id = parents[id];
//        }
//        return id;
//    }
//
//    private boolean connected(int p, int q) {
//        return find(p) == find(q);
//    }
//
//    private void union(int p, int q) {
//        int rootP = find(p);
//        int rootQ = find(q);
//
//        if (rootP == rootQ) return;
//
//        parents[rootP] = rootQ;
//    }
//
//    public int swimInWater(int[][] grid) {
//        int N = grid.length;
//        buildUnionFind(N, N);
//
//        int[] map = new int[N * N];
//        for (int i = 0; i < N; ++i) {
//            for (int j = 0; j < N; ++j) {
//                map[grid[i][j]] = i * N + j;
//            }
//        }
//
//        for (int time = 0; time < N * N; ++time) {
//            int idx = map[time];
//            int row = idx / N;
//            int col = idx % N;
//
//            for (int[] direction : directions) {
//                int rr = row + direction[0], cc = col + direction[1];
//                if (!isValid(rr, cc, grid, time)) continue;
//                union(idx, rr * N + cc);
//            }
//
//            if (connected(0, N * N - 1)) return time;
//        }
//
//        return -1;
//    }
//
//    private boolean isValid(int r, int c, int[][] grid, int time) {
//        return r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] < time;
//    }
    // improved with count rank
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int[] parents;
    private int[] ranks;

    private void buildUnionFind(int rows, int cols) {
        parents = new int[rows * cols];
        ranks = new int[rows * cols];

        for (int i = 0; i < parents.length; ++i) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    private int find(int id) {
        while (id != parents[id]) {
            parents[id] = parents[parents[id]];
            id = parents[id];
        }
        return id;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (ranks[rootP] <= ranks[rootQ]) {
            parents[rootP] = rootQ;
            ranks[rootQ] += ranks[rootP];
        } else {
            parents[rootQ] = rootP;
            ranks[rootP] += ranks[rootQ];
        }
    }

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        buildUnionFind(N, N);

        int[] map = new int[N * N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                map[grid[i][j]] = i * N + j;
            }
        }

        for (int time = 0; time < N * N; ++time) {
            int idx = map[time];
            int row = idx / N;
            int col = idx % N;

            for (int[] direction : directions) {
                int rr = row + direction[0], cc = col + direction[1];
                if (!isValid(rr, cc, grid, time)) continue;
                union(idx, rr * N + cc);
            }

            if (connected(0, N * N - 1)) return time;
        }

        return -1;
    }

    private boolean isValid(int r, int c, int[][] grid, int time) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] < time;
    }
}
