package exercises.leetcode1001_1200;

import java.util.Arrays;

public class CarPooling1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] route = new int[1001];
        Arrays.fill(route, capacity);
        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                route[i] = route[i] - trip[0];
                if (route[i] < 0) return false;
            }
        }

        return true;
    }
}
