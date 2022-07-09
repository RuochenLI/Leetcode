package exercises.leetcode2001_2200;

import java.util.Map;
import java.util.TreeMap;

public class AmountOfNewAreaPaintedEachDay_2158 {
    // 考虑各种边界，细节。。。
    public int[] amountPainted(int[][] paint) {
        TreeMap<Integer, Integer> segmentTree = new TreeMap<>();
        int[] result = new int[paint.length];
        for (int i = 0; i < paint.length; i++) {
            int[] p = paint[i];
            int start = p[0];
            Map.Entry<Integer, Integer> preEntry = segmentTree.floorEntry(p[0]);
            //之前刷的油漆完全覆盖了新paint
            if (preEntry != null && preEntry.getValue() >= p[1]) {
                result[i] = 0;
                continue;
            }

            if (preEntry != null && preEntry.getValue() >= p[0]) {
                // 之前刷的油漆不完全覆盖新油漆前边
                result[i] = p[1] - preEntry.getValue();
                start = preEntry.getKey();
            } else {
                // 之前刷的油漆不覆盖新油漆前边
                result[i] = p[1] - p[0];
            }

            // 之前刷的油漆在新刷的油漆里边，有可能好几个segment
            Map.Entry<Integer, Integer> postEntry = segmentTree.higherEntry(p[0]);
            while (postEntry != null && postEntry.getKey() > p[0] && postEntry.getValue() <= p[1]) {
                result[i] -= (postEntry.getValue() - postEntry.getKey());
                segmentTree.remove(postEntry.getKey());
                postEntry = segmentTree.higherEntry(p[0]);
            }

            // 之前刷的油漆覆盖新刷油漆尾部，不完全覆盖
            if (postEntry != null && postEntry.getKey() <= p[1] && postEntry.getValue() >= p[1]) {
                result[i] -= (p[1] - postEntry.getKey());
                segmentTree.put(start, postEntry.getValue());
                segmentTree.remove(postEntry.getKey());
                continue;
            }

            segmentTree.put(start, p[1]);
        }
        return result;
    }
}
