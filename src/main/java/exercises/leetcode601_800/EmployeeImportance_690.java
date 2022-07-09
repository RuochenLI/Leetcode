package exercises.leetcode601_800;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance_690 {
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
