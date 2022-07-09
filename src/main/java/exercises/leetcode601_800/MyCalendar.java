package exercises.leetcode601_800;

import java.util.Map;
import java.util.TreeMap;

/**
 * 729. My Calendar I
 */
public class MyCalendar {
    TreeMap<Integer, Integer> segments;

    public MyCalendar() {
        segments = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = segments.lowerEntry(end);
        if (entry == null || entry.getValue() <= start) {
            segments.put(start, end);
            return true;
        }
        return false;
    }
}
