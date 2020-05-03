package exercises;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * Created by liruochen on 4/1/17.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            queue.forEach(node -> currentLevel.add(node.val));
            result.add(0, currentLevel);
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
