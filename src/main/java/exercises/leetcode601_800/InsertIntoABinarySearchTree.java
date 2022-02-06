package exercises.leetcode601_800;

import helper.TreeNode;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode current = root;
        while (val > current.val && current.right != null || val < current.val && current.left != null) {
            current = val > current.val ? current.right : current.left;
        }
        if (val > current.val)
            current.right = new TreeNode(val);
        else
            current.left = new TreeNode(val);

        return root;
    }
}
