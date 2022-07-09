package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        dfs(0, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void dfs(int current, List<Integer> com, int[] candidates, int target, int start) {
        if (current == target) {
            result.add(List.copyOf(com));
            return;
        }

        if (current > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (current + candidate <= target) {
                com.add(candidate);
                dfs(current + candidate, com, candidates, target, i);
                com.remove((Integer) candidate);
            }
        }
    }
}
