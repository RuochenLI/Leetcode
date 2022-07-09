package exercises.leetcode601_800;

import java.util.LinkedList;
import java.util.List;

public class ExclusiveTimeOfFunctions_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        LinkedList<int[]> threadSteak = new LinkedList<>();
        for (String log : logs) {
            String[] info = log.split(":");
            if ("start".equals(info[1])) {
                threadSteak.push(new int[]{Integer.parseInt(info[0]), Integer.parseInt(info[2]), 0});
            } else {
                int[] startedThread = threadSteak.pop();
                int executionTime = Integer.parseInt(info[2]) - startedThread[1] + 1;
                result[startedThread[0]] += executionTime - startedThread[2];
                if (!threadSteak.isEmpty()) {
                    threadSteak.peek()[2] += executionTime;
                }
            }
        }
        return result;
    }
}
