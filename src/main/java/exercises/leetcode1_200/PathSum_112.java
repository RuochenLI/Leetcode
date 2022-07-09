package exercises.leetcode1_200;

import helper.TreeNode;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    private boolean result;

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.result = false;
        dfs(root, targetSum, root.val);
        return this.result;
    }

    public void dfs(TreeNode node, int target, int current) {
        if (this.result || node.left == null && node.right == null && current == target) {
            this.result = true;
            return;
        }

        if (node.left != null) {
            dfs(node.left, target, current + node.left.val);
        }

        if (node.right != null) {
            dfs(node.right, target, current + node.right.val);
        }
    }
}
