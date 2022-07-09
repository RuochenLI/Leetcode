package exercises.leetcode601_800;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class EmployeeFreeTime_759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (List<Interval> emp : schedule) {
            for (Interval interval : emp) {
                tree.put(interval.start, tree.getOrDefault(interval.start, 0) + 1);
                tree.put(interval.end, tree.getOrDefault(interval.end, 0) - 1);
            }
        }

        int presum = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = tree.entrySet().iterator();
        List<Interval> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> current = iterator.next();
            presum += current.getValue();
            if (presum == 0 && iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                presum += next.getValue();
                result.add(new Interval(current.getKey(), next.getKey()));
            }
        }
        return result;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
}
