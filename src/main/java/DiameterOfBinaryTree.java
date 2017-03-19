import common.TreeNode;

/**
 * Created by Ruochen on 19/03/2017.
 */
public class DiameterOfBinaryTree {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getLongestDistance(root);
        return result;
    }

    private int getLongestDistance(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int left = current.left == null ? 0 : getLongestDistance(current.left) + 1;
        int right = current.right == null ? 0 : getLongestDistance(current.right) + 1;
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }
}
