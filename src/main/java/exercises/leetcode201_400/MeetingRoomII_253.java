package exercises.leetcode201_400;

import java.util.Arrays;

public class MeetingRoomII_253 {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] schedule = new int[1000001];
        int start = 1000001;
        int end = 0;
        for (int[] interval : intervals) {
            start = Math.min(start, interval[0]);
            end = Math.max(end, interval[1]);
            schedule[interval[0]]++;
            schedule[interval[1]]--;
        }

        int presum = 0;
        int result = 0;
        for (int i = start; i <= end; i++) {
            presum += schedule[i];
            if (schedule[i] > 0) {
                result = Math.max(result, presum);
            }
        }
        return result;
    }
}
