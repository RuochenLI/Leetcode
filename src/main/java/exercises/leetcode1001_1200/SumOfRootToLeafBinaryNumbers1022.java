package exercises.leetcode1001_1200;

import helper.TreeNode;

public class SumOfRootToLeafBinaryNumbers1022 {
    int sum;
    public int sumRootToLeaf(TreeNode root) {
        visit(root, 0);
        return sum;
    }

    public void visit(TreeNode node, int current) {
        if (node != null) {
            current = (current << 1) | node.val;
            if (node.left == null && node.right == null)  sum += current;
            visit(node.left, current);
            visit(node.right, current);
        }
    }
}
