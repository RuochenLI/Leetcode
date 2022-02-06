package exercises.leetcode201_400;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class PaintFence276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;

        int[][] result = new int[n][2];
        result[0][0] = k;
        for (int i = 1; i < n; i++) {
            result[i][1] = result[i - 1][0];
            result[i][0] = (result[i - 1][0] + result[i - 1][1]) * (k - 1);
        }

        return result[n - 1][1] + result[n - 1][0];
    }
}
