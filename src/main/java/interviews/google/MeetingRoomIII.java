package interviews.google;

import java.util.*;

public class MeetingRoomIII {
    public boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] ask) {
        int[] visit = new int[50050];
        int maxLength = 0;
        for (int[] interval : intervals) {
            visit[interval[0]]++;
            visit[interval[1]]--;
            maxLength = Math.max(maxLength, interval[1]);
        }
        for (int[] a : ask) {
            maxLength = Math.max(maxLength, a[1]);
        }

        boolean[] needMoreMeetingRoom = new boolean[maxLength];
        int countMeetingRooms = 0;
        for (int i = 1; i < maxLength; i++) {
            countMeetingRooms += visit[i];
            needMoreMeetingRoom[i] = countMeetingRooms >= rooms;
        }

        /*
        给定新的会议(a,b)问题就转化为，问[ a , a + 1 , . . . , b − 1 ] [a,a+1,...,b-1][a,a+1,...,b−1]这些位置上的needMoreMeetingRoom都是false，也就是问以sum [ a − 1 ] 为结尾的前缀和是否等于以sum [ b − 1 ]结尾的前缀和。
         */
        int[] sum = new int[maxLength];
        for (int i = 1; i < maxLength; i++) {
            sum[i] = sum[i - 1] + (needMoreMeetingRoom[i] ? 1 : 0);
        }

        boolean[] result = new boolean[ask.length];
        for (int i = 0; i < ask.length; i++) {
            result[i] = sum[ask[i][0] - 1] == sum[ask[i][1] - 1];
        }
        return result;
    }

    public boolean[] meetingRoomIII1(int[][] intervals, int rooms, int[][] ask) {
        PriorityQueue<int[]> meetings = new PriorityQueue<>(Comparator.comparingInt(interval -> interval[1]));
        PriorityQueue<Interval> askList = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.start));
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for (int i = 0; i < ask.length; i++) {
            askList.add(new Interval(ask[i][0], ask[i][1], i));
        }
        int intPointer = 0;
        boolean[] ans = new boolean[ask.length];
        while (intPointer < intervals.length && !askList.isEmpty()) {
            if (askList.peek().start >= intervals[intPointer][0]) {
                if (!meetings.isEmpty() && meetings.peek()[1] <= intervals[intPointer][0]) {
                    while (!meetings.isEmpty() && meetings.peek()[1] <= intervals[intPointer][0]) {
                        meetings.poll();
                    }
                }
                meetings.add(intervals[intPointer]);
                intPointer++;
            } else {
                while (!meetings.isEmpty() && meetings.peek()[1] <= askList.peek().start) {
                    meetings.poll();
                }
                int availableRooms = rooms - meetings.size();
                if (availableRooms <= 0) {
                    ans[askList.peek().index] = false;
                    askList.poll();
                } else {
                    if (askList.peek().end <= intervals[intPointer][0]) {
                        ans[askList.peek().index] = true;
                        askList.poll();
                    } else {
                        Interval currentAsk = askList.poll();
                        askList.add(new Interval(intervals[intPointer][0], currentAsk.end, currentAsk.index));
                    }
                }
            }
        }
        while (!askList.isEmpty()) {
            ans[askList.poll().index] = true;
        }
        return ans;
    }

    public static class Interval {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public boolean[] meetingRoomIII3(int[][] intervals, int rooms, int[][] ask) {
        int[] visit = new int[50050];
        int maxLength = 0;
        for (int[] interval : intervals) {
            visit[interval[0]]++;
            visit[interval[1]]--;
            maxLength = Math.max(maxLength, interval[1]);
        }
        for (int[] a : ask) {
            maxLength = Math.max(maxLength, a[1]);
        }

        int countMeetingRooms = 0;
        int[] sum = new int[maxLength];
        for (int i = 1; i < maxLength; i++) {
            countMeetingRooms += visit[i];
            sum[i] = sum[i - 1] + (countMeetingRooms >= rooms ? 1 : 0);
        }

        boolean[] result = new boolean[ask.length];
        for (int i = 0; i < ask.length; i++) {
            result[i] = sum[ask[i][0] - 1] == sum[ask[i][1] - 1];
        }
        return result;
    }
}
