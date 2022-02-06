package exercises.leetcode401_600;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBallons452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int result = 1;
        int arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (arrow < points[i][0]) {
                result++;
                arrow = points[i][1];
            }
        }
        return result;
    }
}
