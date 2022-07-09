package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import helper.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);

        return result;
    }

    public void dfs(TreeNode node, List<List<Integer>> result, int currentLevel) {
        if (node == null) {
            return;
        }

        if (result.size() <= currentLevel) {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }

        List<Integer> collection = result.get(currentLevel);
        if (currentLevel % 2 == 0) {
            collection.add(node.val);
        } else {
            collection.add(0, node.val);
        }
        dfs(node.left, result, currentLevel + 1);
        dfs(node.right, result, currentLevel + 1);
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs1(root, levelMap, 0);
        levelMap.forEach((key, value) -> {
            if (key % 2 != 0) {
                Collections.reverse(value);
            }
            List<Integer> level = new ArrayList<>(value);
            result.add(level);
        });

        return result;
    }

    public void dfs1(TreeNode node, Map<Integer, List<Integer>> levelMap, int currentLevel) {
        if (node == null) {
            return;
        }

        dfs1(node.left, levelMap, currentLevel + 1);
        levelMap.computeIfAbsent(currentLevel, k -> new ArrayList<>()).add(node.val);
        dfs1(node.right, levelMap, currentLevel + 1);
    }
}
