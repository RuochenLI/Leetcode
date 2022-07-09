package exercises.leetcode401_600;

import java.util.HashMap;
import java.util.Map;

import helper.TreeNode;

public class PathSumIII_437 {
    private int solution;
    private Map<Integer, Integer> sumMap;

    public int pathSum(TreeNode root, int targetSum) {
        solution = 0;
        sumMap = new HashMap<>();
        sumMap.put(0, 1);
        visit(root, 0, targetSum);
        return solution;
    }

    private void visit(TreeNode node, int currentSum, int targetSum) {
        if (node == null) return;

        currentSum += node.val;

        solution += sumMap.getOrDefault(currentSum - targetSum, 0);
        sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);

        visit(node.left, currentSum, targetSum);
        visit(node.right, currentSum, targetSum);

        sumMap.put(currentSum, sumMap.get(currentSum) - 1);
    }
}
