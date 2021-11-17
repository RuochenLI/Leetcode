package challenge.year2021;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return walk(m, n);
    }

    private int walk(int x, int y) {
        if (x == 1 && y == 1) {
            return 1;
        }

        int goRight = 0;
        int goDown = 0;

        if (x > 0) {
            goRight = walk(x - 1, y);
        }

        if (y > 0) {
            goDown = walk(x, y -1);
        }

        return goDown + goRight;
    }

    public int uniquePaths1(int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            ans[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[m - 1][n - 1];
    }
}
