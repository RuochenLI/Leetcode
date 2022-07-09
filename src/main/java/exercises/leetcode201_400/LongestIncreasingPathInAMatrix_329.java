package exercises.leetcode201_400;

public class LongestIncreasingPathInAMatrix_329 {
    public static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        cache = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = dfs(matrix, cache, i, j, m, n);
                result = Math.max(result, cache[i][j]);
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int[][] cache, int i, int j, int m, int n) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        cache[i][j] = 1;
        for (int[] dict : DIRECTION) {
            int x = i + dict[0];
            int y = j + dict[1];
            if (x >= 0 && x < m && y >=0 && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, x, y, m, n) + 1);
            }
        }
        return cache[i][j];
    }
}
