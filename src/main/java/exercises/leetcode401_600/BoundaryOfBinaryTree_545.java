package exercises.leetcode401_600;

import java.util.ArrayList;
import java.util.List;

import helper.TreeNode;

public class BoundaryOfBinaryTree_545 {
    List<Integer> result;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);

        if (root.left != null) {
            diveLeft(root.left);
        }
        dfs(root);
        if (root.right != null) {
            diveRight(root.right);
        }

        return result;
    }

    public void diveLeft(TreeNode node) {
        if (node.left != null || node.right != null) {
            result.add(node.val);
        }
        if (node.left != null) {
            diveLeft(node.left);
        } else if (node.right != null) {
            diveLeft(node.right);
        }

    }

    public void dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        if (node.left != null) {
            dfs(node.left);
        }

        if (node.right != null) {
            dfs(node.right);
        }
    }

    public void diveRight(TreeNode node) {
        if (node.right != null) {
            diveRight(node.right);
        } else if (node.left != null) {
            diveRight(node.left);
        }
        if (node.left != null || node.right != null) {
            result.add(node.val);
        }
    }
}
