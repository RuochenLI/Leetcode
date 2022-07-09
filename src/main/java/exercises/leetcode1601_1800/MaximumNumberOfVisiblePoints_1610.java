package exercises.leetcode1601_1800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610. Maximum Number of Visible Points
 */
public class MaximumNumberOfVisiblePoints_1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            }
            angles.add(Math.toDegrees(Math.atan2(dy, dx)));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) {
            tmp.add(d + 360); // concatenate to handle edge case
        }
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }
}
