package exercises;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * Created by liruochen on 4/1/17.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            queue.forEach(node -> currentLevel.add(node.val));
            result.add(currentLevel);
            queue = prepareForTheNextLevel(queue);
        }
        return result;
    }

    private Queue<TreeNode> prepareForTheNextLevel(Queue<TreeNode> queue) {
        Queue<TreeNode> nextLevel = new LinkedList<>();
        queue.forEach(node -> {
            if (node.left != null) {
                nextLevel.add(node.left);
            }

            if (node.right != null) {
                nextLevel.add(node.right);
            }
        });
        return nextLevel;
    }
}
