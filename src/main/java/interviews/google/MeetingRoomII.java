package interviews.google;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        int ans = 0;
        for (Interval interval : intervals) {
            if (priorityQueue.isEmpty() || priorityQueue.peek().end >= interval.start) {
                priorityQueue.add(interval);
                ans = Math.max(ans, priorityQueue.size());
            } else {
                while (!priorityQueue.isEmpty() && priorityQueue.peek().end < interval.start) {
                    priorityQueue.poll();
                }
                priorityQueue.add(interval);
            }
        }
        return ans;
    }

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
