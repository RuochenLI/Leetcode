package exercises.leetcode2001_2200;

import java.util.HashMap;
import java.util.Map;

/**
 * 2013. Detect Squares
 */
public class DetectSquares {
    Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        this.map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        this.map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = this.map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        Map<Integer, Integer> yMap = this.map.get(x1);
        int result = 0;
        if (yMap == null) {
            return 0;
        }
        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            if (entry.getKey() == y1) {
                continue;
            }
            int y2 = entry.getKey();
            int distance = Math.abs(y2 - y1);

            Map<Integer, Integer> yMap2;
            if (map.containsKey(x1 + distance)) {
                yMap2 = map.get(x1 + distance);
                result += (entry.getValue() * yMap2.getOrDefault(y1, 0) * yMap2.getOrDefault(y2, 0));
            }

            if (map.containsKey(x1 - distance)) {
                yMap2 = map.get(x1 - distance);
                result += (entry.getValue() * yMap2.getOrDefault(y1, 0) * yMap2.getOrDefault(y2, 0));
            }
        }

        return result;
    }
}
