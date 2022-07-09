package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.TreeNode;

public class FindLeavesOfBinaryTree_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        dfs(root, levelMap);
        result.addAll(levelMap.values());
        return result;
    }

    public int dfs(TreeNode node, Map<Integer, List<Integer>> levelMap) {
        if (node.left == null && node.right == null) {
            levelMap.computeIfAbsent(0, k -> new ArrayList<>()).add(node.val);
            return 0;
        }
        int leftLevel = 0, rightLevel = 0;
        if (node.left != null) {
            leftLevel = dfs(node.left, levelMap);
        }
        if (node.right != null) {
            rightLevel = dfs(node.right, levelMap);
        }
        int level = Math.max(rightLevel, leftLevel) + 1;
        levelMap.computeIfAbsent(level, k -> new ArrayList<>()).add(node.val);
        return level;
    }

    public List<List<Integer>> findLeaves0(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> depthMap = new HashMap<>();
        int depth = getDepth(root, depthMap);
        for (int i = 1; i <= depth; i++) {
            result.add(depthMap.get(i));
        }
        return result;
    }

    private int getDepth(TreeNode node, Map<Integer, List<Integer>> depthMap) {
        if (node == null) {
            return 0;
        }

        int depth = Math.max(getDepth(node.left, depthMap), getDepth(node.right, depthMap)) + 1;
        List<Integer> depthList = depthMap.getOrDefault(depth, new ArrayList<>());
        depthList.add(node.val);
        depthMap.put(depth, depthList);
        return depth;
    }

}
