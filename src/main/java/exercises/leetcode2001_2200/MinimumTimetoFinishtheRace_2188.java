package exercises.leetcode2001_2200;

import java.util.Arrays;

/**
 * 2188. Minimum Time to Finish the Race
 */
public class MinimumTimetoFinishtheRace_2188 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] minTimeToFinishLoop = new int[numLaps + 1];
        Arrays.fill(minTimeToFinishLoop, Integer.MAX_VALUE);

        for (int[] tire : tires) {
            populateMinTires(minTimeToFinishLoop, tire, numLaps, changeTime);
        }

        for (int i = 2; i <= numLaps; i++) {
            for (int j = 1; j < i; j++) {
                minTimeToFinishLoop[i] = Math.min(minTimeToFinishLoop[i],
                                                  minTimeToFinishLoop[j] + minTimeToFinishLoop[i - j] + changeTime);
            }
        }

        return minTimeToFinishLoop[numLaps];
    }

    /**
     * populate minimum time - based on base and expx
     * incremental-change < base + changeTime
     * dont need to populate more than when that above condition
     * turns false. Since at that point -- we will rinse and repeat.
     */
    private void populateMinTires(int[] minTime, int[] tire, int numLaps, int changeTime) {
        int base = tire[0];
        int expx = tire[1];

        int curr = base;
        int sumx = base;

        int curlap = 1;
        minTime[curlap] = Math.min(minTime[curlap], curr);
        while (curlap + 1 <= numLaps && curr * expx <= base + changeTime) {
            curlap++;

            curr = curr * expx;
            sumx = sumx + curr;
            minTime[curlap] = Math.min(minTime[curlap], sumx);
        }
    }
}
