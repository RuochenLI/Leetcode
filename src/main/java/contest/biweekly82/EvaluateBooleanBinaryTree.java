package contest.biweekly82;

import helper.TreeNode;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return  false;
        }

        if (root.val == 0) {
            return false;
        }

        if (root.val == 1) {
            return true;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2 ? left || right : left && right;
    }
}
