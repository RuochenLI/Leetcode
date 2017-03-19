import common.TreeNode;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
 \
 3
 /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 * Created by Ruochen on 19/03/2017.
 */
public class MinimumAbsoluteDifferenceInBST {
    int result = -1;
    TreeNode nextNumNode = null;

    public int getMinimumDifference(TreeNode root) {
        searchInTheTree(root);
        return result;
    }

    private void searchInTheTree(TreeNode current) {
        if (current == null) {
            return;
        }

        searchInTheTree(current.left);
        if (nextNumNode != null) {
            int diff = Math.abs(current.val - nextNumNode.val);
            result = (result == -1) ? diff : Math.min(diff, result);
        }
        nextNumNode = current;
        searchInTheTree(current.right);
    }
}
