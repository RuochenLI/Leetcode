package exercises.leetcode1201_1400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 1376. Time Needed to Inform All Employees
 */
public class TimeNeededToInformAllEmployees_1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        Map<Integer, List<Integer>> employeeTree = new HashMap<>(n);

        for (int i = 0; i < manager.length; i++) {
            int m = manager[i];
            List<Integer> reports = employeeTree.getOrDefault(m, new ArrayList<>());
            reports.add(i);
            employeeTree.put(m, reports);
        }

        stack.push(new int[]{headID, informTime[headID]});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            if (employeeTree.containsKey(current[0])) {
                for (int direct : employeeTree.get(current[0])) {
                    stack.push(new int[]{direct, current[1] + informTime[direct]});
                }
            } else {
                result = Math.max(current[1], result);
            }
        }

        return result;
    }
}
