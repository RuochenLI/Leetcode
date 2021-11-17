package challenge.year2021;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[height - 1][width - 1] == 1) {
            return 0;
        }

        int[][] ans = new int[height][width];
        ans[0][0] = 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i > 0 || j > 0) {
                    int above = i == 0 ? 0 : ans[i - 1][j];
                    int left = j == 0 ? 0 : ans[i][j - 1];
                    ans[i][j] = obstacleGrid[i][j] == 1 ? 0 : above + left;
                }
            }
        }
        return ans[height - 1][width - 1];
    }
}
