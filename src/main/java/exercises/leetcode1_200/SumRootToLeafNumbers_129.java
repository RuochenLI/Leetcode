package exercises.leetcode1_200;

import helper.TreeNode;

public class SumRootToLeafNumbers_129 {
    private int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        visit(root, 0);
        return sum;
    }

    public void visit(TreeNode node, int currentSum) {
        if (node == null) return;

        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += currentSum;
        }
        visit(node.left, currentSum);
        visit(node.right, currentSum);
    }
//    public int sumNumbers(TreeNode root) {
//        if (root == null) return 0;
//
//        sum = 0;
//        visit(root, new StringBuilder());
//        return sum;
//    }
//
//    public void visit(TreeNode node, StringBuilder currentSum) {
//        currentSum.append(node.val);
//        if (node.left == null && node.right == null) {
//            sum += Integer.parseInt(currentSum.toString());
//            currentSum.deleteCharAt(currentSum.length() - 1);
//            return;
//        }
//
//        if (node.left != null) {
//            visit(node.left, currentSum);
//        }
//
//        if (node.right != null) {
//            visit(node.right, currentSum);
//        }
//        currentSum.deleteCharAt(currentSum.length() - 1);
//    }
}
