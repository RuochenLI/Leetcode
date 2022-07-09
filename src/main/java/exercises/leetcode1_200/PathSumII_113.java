package exercises.leetcode1_200;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import helper.TreeNode;

public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, root.val, result, Stream.of(root.val).collect(Collectors.toList()));
        return result;
    }

    public void dfs( TreeNode node, int target, int current, List<List<Integer>> result, List<Integer> currentList) {
        if (node.left == null && node.right == null){
            if (target == current) {
                result.add(List.copyOf(currentList));
            }
            return;
        }

        if (node.left != null) {
            currentList.add(node.left.val);
            dfs(node.left, target, current + node.left.val, result, currentList);
            currentList.remove(currentList.size() - 1);
        }

        if (node.right != null) {
            currentList.add(node.right.val);
            dfs(node.right, target, current + node.right.val, result, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
