package interviews.google;

public class CountSquareSubmatricesWithAllOnes {
    /**
     * Nice explanation: https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/447967/JAVA-DP-7ms-with-explanation-O(m*n)-time-100-space
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;
                if (i > 0 && j > 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i- 1][j - 1]) + 1;
                }
                result += matrix[i][j];
            }
        }
        return result;
    }

    public int countSquares1(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][][] dp = new int[height][width][Math.min(height, width)];
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j][0] = 1;
                    res++;
                }
                for (int k = 1; k <= Math.min(i, j); k++) {
                    if (isSquare(i, j, k, dp)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean isSquare(int x, int y, int k, int[][][] dp) {
        if (dp[x -1][y - 1][k -1] == 0) return false;

        for (int i = x - k; i <= x; i++) {
            if (dp[i][y][0] == 0 || dp[i][y - k][0] == 0) return false;
        }

        for (int i = y - k; i <= y; i++) {
            if (dp[x][i][0] == 0 || dp[x - k][i][0] == 0) return false;
        }

        return true;
    }
}
