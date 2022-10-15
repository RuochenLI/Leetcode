package exercises.leetcode2200_2400;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2345. Finding the Number of Visible Mountains
 */
public class FindingTheNumberOfVisibleMountains_2345 {
    public int visibleMountains(int[][] peaks) {
        int[][] ranges = new int[peaks.length][2];
        for (int i = 0; i < peaks.length; i++) {
            ranges[i][0] = peaks[i][0] - peaks[i][1];
            ranges[i][1] = peaks[i][0] + peaks[i][1];
        }

        Arrays.sort(ranges, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        Stack<int[]> stack = new Stack<>();
        boolean duplicate = false;
        for (int i = 0; i < peaks.length; i++) {
            // remove duplicate
            while (!stack.isEmpty() &&
                   i < peaks.length &&
                   stack.peek()[0] == ranges[i][0] &&
                   stack.peek()[1] == ranges[i][1]) {
                i++;
                duplicate = true;
            }
            if (duplicate) {
                stack.pop();
                duplicate = false;
                continue;
            }

            // same x, by smaller y
            while (!stack.isEmpty() && stack.peek()[0] == ranges[i][0] &&stack.peek()[1] < ranges[i][1]) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek()[1] < ranges[i][1])
                stack.push(ranges[i]);
            }

        return stack.size();
    }

}
