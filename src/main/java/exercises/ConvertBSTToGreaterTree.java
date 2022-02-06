package exercises;

import helper.TreeNode;

/**
 * 538. Convert BST to Greater Tree
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13
 * Created by Ruochen on 25/03/2017.
 */
public class ConvertBSTToGreaterTree {
    private int cumulativeValue = 0;

    public TreeNode convertBST(TreeNode root) {
        transform(root);
        return root;
    }

    private void transform(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            transform(root.right);
        }

        int temp = root.val;
        root.val += cumulativeValue;
        cumulativeValue += temp;

        if (root.left != null) {
            transform(root.left);
        }
    }
}
