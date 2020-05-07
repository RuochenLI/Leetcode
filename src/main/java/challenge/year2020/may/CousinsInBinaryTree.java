package challenge.year2020.may;

public class CousinsInBinaryTree {

    /*
        In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

        Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

        We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

        Return true if and only if the nodes corresponding to the values x and y are cousins.
        炫耀一下下，程序虽丑但。。。效率高😂
        Submission Detail
        103 / 103 test cases passed.
        Status: Accepted
        Runtime: 0 ms
        Memory Usage: 37.4 MB
        Submitted: 0 minutes ago
     */
    int depX = -1;
    int depY = -1;
    TreeNode parentX = null;
    TreeNode parentY = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        return dive_deep(root, x, y, 0, null);
    }

    private boolean dive_deep(final TreeNode node, final int x, final int y, final int depth, final TreeNode parent) {
        int currentDepth = depth + 1;
        if (node.val == x) {
            depX = currentDepth;
            parentX = parent;
        }

        if (node.val == y) {
            depY = currentDepth;
            parentY = parent;
        }

        if (depX != -1 && depY != -1)
            return depX == depY && parentX != parentY;

        boolean result = false;

        if (node.left != null)
            result = dive_deep(node.left, x, y, currentDepth, node);

        if (node.right != null)
            result = result || dive_deep(node.right, x, y, currentDepth, node);

        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
