package exercises.leetcode1801_2000;

public class MaximumNumberOfPointsWithCost_1937 {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        long result = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }

        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = dp[i - 1][0];
            right[n - 1] = dp[i - 1][n - 1];
            for (int j = 1; j < n; ++j) {
                left[j] = Math.max(left[j - 1] - 1, dp[i - 1][j]);
            }
            for (int j = n - 2; j >= 0; --j) {
                right[j] = Math.max(right[j + 1] - 1, dp[i - 1][j]);
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(left[j], right[j]) + points[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[m - 1][i]);
        }
        return result;
    }

    public long maxPoints1(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        long result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[0][j] = points[0][j];
                } else {
                    for (int k = 0; k < n; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + points[i][j] - Math.abs(k - j));
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
