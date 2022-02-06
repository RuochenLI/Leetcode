package context.biweekly66;

public class MinCost {
    public int minCost1(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int[][] dp = new int[rowCosts.length][colCosts.length];
        int startX = startPos[0];
        int startY = startPos[1];
        int endX = homePos[0];
        int endY = homePos[1];
        if (endY < startY || endX < startX) {
            int tempX = startX;
            startX = endX;
            endX = tempX;
            int tempY = startY;
            startY = endY;
            endY = tempY;
        }

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (i == startX && j == startY) {
                    dp[i][j] = 0;
                } else {
                    if (j > startY) {
                        dp[i][j]= dp[i][j - 1] + colCosts[j];
                    } else if (i > startX) {
                        dp[i][j] = dp[i - 1][j] + rowCosts[i];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + rowCosts[i], dp[i][j - 1] + colCosts[j]);
                    }
                }
            }
        }
        return dp[endX][endY];
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startX = startPos[0];
        int startY = startPos[1];
        int endX = homePos[0];
        int endY = homePos[1];
        int ans = 0;
        if (endY > startY) {
            for (int i = startY + 1; i <= endY; i++) {
                ans += colCosts[i];
            }
        } else {
            for (int i = startY - 1; i >= endY; i--) {
                ans += colCosts[i];
            }
        }
        if (endX > startX) {
            for (int i = startX + 1; i <= endX; i++) {
                ans += rowCosts[i];
            }
        } else {
            for (int i = startX - 1; i >= endX; i--) {
                ans += rowCosts[i];
            }
        }
        return ans;
    }
}
