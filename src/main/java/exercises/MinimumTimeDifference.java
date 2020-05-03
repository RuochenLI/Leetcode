package exercises;

import java.util.Collections;
import java.util.List;

/**
Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1
 * Created by ruli on 3/17/2017.
 */
public class MinimumTimeDifference {
   private static final int MIN_IN_A_DAY = 1440;

   //solution 1: O(nlog(n)) Time O(1) Space:
   public int findMinDifference(List<String> timePoints) {
      Collections.sort(timePoints);
      int result = distance(timePoints.get(0), timePoints.get(timePoints.size() - 1));
      int index = 1;
      while (index < timePoints.size()) {
         result = Math.min(result, distance(timePoints.get(index), timePoints.get(index - 1)));
         index++;
      }
      return result;
   }

   public int distance(String t1, String t2) {
      String[] time1 = t1.split(":");
      String[] time2 = t2.split(":");
      int t1h = Integer.valueOf(time1[0]);
      int t1min = Integer.valueOf(time1[1]);
      int t2h = Integer.valueOf(time2[0]);
      int t2min = Integer.valueOf(time2[1]);

      int distance = Math.abs((t2h - t1h) * 60 + t2min - t1min);
      return Math.min(distance, MIN_IN_A_DAY - distance);
   }

   /*
      another solution proposed by others:
      O(n) Time O(1) Space. Note that, more accurately, this is O(1) time as the number of iterations of the first loop is limited to 1440 due to the pigeonhole principle.
   */
   //public int findMinDifference(List<String> timePoints) {
   //
   //    boolean[] timeSeen = new boolean[1440];
   //    for (String s : timePoints) {
   //        int mins = Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
   //        if (timeSeen[mins]) return 0;
   //        timeSeen[mins] = true;
   //    }
   //
   //    Integer firstTimeSeen = null, prevTimeSeen = null, minDiff = Integer.MAX_VALUE;
   //    for (int i=0;i<1440;i++) {
   //        if (!timeSeen[i]) continue;
   //        if (firstTimeSeen == null) {firstTimeSeen = i; prevTimeSeen = i;}
   //        else {
   //          minDiff = Math.min(minDiff, Math.min(i - prevTimeSeen, 1440 - i + prevTimeSeen));
   //          prevTimeSeen = i;
   //        }
   //    }
   //
   //    minDiff = Math.min(minDiff, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));
   //    return minDiff;
   //}

}
