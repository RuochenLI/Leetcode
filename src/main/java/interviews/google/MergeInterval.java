package interviews.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = interval[1];
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public List<MergeInterval.Interval> merge1(List<MergeInterval.Interval> intervals) {
        if (intervals.isEmpty() || intervals.size() == 1) {
            return intervals;
        }

        List<MergeInterval.Interval> result = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));

        MergeInterval.Interval currentInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            MergeInterval.Interval nextInterval = intervals.get(i);
            if (currentInterval.end >= nextInterval.start) {
                if (currentInterval.end < nextInterval.end) currentInterval.end = nextInterval.end;
            } else {
                result.add(new MergeInterval.Interval(currentInterval.start, currentInterval.end));
                currentInterval.start = nextInterval.start;
                currentInterval.end = nextInterval.end;
            }
        }
        result.add(currentInterval);
        return result;
    }

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
