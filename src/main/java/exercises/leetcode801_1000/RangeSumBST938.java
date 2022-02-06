package exercises.leetcode801_1000;

public class RangeSumBST938 {
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root==null) return 0;

        if (root.val>high) return rangeSumBST(root.left, low,high);

        if (root.val<low) return rangeSumBST(root.right, low,high);

        return root.val+rangeSumBST(root.left, low,high) + rangeSumBST(root.right, low,high);
    }
    public static class TreeNode {
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
