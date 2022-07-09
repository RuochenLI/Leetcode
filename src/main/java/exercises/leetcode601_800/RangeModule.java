package exercises.leetcode601_800;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 715. Range Module
 */
public class RangeModule {
    TreeMap<Integer, Integer> range;

    public RangeModule() {
        this.range = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right <= left) return;
        Integer start = range.floorKey(left);
        Integer end = range.floorKey(right);
        if (start == null && end == null) {
            range.put(left, right);
        } else if (start != null && range.get(start) >= left) {
            range.put(start, Math.max(range.get(end), Math.max(range.get(start), right)));
        } else {
            range.put(left, Math.max(range.get(end), right));
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = range.subMap(left, false, right, true);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        range.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> floorEntry = this.range.floorEntry(left);
        return floorEntry != null && floorEntry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = range.floorKey(left);
        Integer end = range.floorKey(right);
        if (end != null && range.get(end) > right) {
            range.put(right, range.get(end));
        }
        if (start != null && range.get(start) > left) {
            range.put(start, left);
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = range.subMap(left, true, right, false);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        range.keySet().removeAll(set);
    }
}
