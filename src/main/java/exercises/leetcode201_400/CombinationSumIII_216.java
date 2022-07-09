package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();

        dfs(0, new ArrayList<>(), k, n, 1);
        return result;
    }

    public void dfs(int current, List<Integer> com, int k, int n, int start) {
        if (current == n && com.size() == k) {
            result.add(List.copyOf(com));
            return;
        }

        if (current > n || com.size() == k) {
            return;
        }

        for (int i = start; i <= Math.min(9, n - current); i++) {
            if (!com.contains(i) && current + i <= n) {
                com.add(i);
                dfs(current + i, com, k, n, i + 1);
                com.remove((Integer) i);
            }
        }
    }
}
