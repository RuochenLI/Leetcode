package exercises.leetcode401_600;

/**
 * 562. Longest Line of Consecutive One in Matrix
 */
public class LongestLineOfConsecutiveOneInMatrix_562 {
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] diagonal = new int[m][n];
        int[][] horizontal = new int[m][n];
        int[][] vertical = new int[m][n];
        int[][] antiDiagonal = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonal[i][j] = mat[i][j] == 0 || i == 0 || j == 0 ? mat[i][j] : diagonal[i - 1][j - 1] + 1;
                horizontal[i][j] = mat[i][j] == 0 || j == 0 ? mat[i][j] : horizontal[i][j - 1] + 1;
                vertical[i][j] = mat[i][j] == 0 || i == 0 ? mat[i][j] : vertical[i - 1][j] + 1;
                antiDiagonal[i][j] = mat[i][j] == 0 || i == 0 || j == n - 1 ? mat[i][j] : antiDiagonal[i - 1][j + 1] + 1;

                result = Math.max(Math.max(Math.max(Math.max(diagonal[i][j], horizontal[i][j]), vertical[i][j]), antiDiagonal[i][j]), result);
            }
        }
        return result;
    }
}
