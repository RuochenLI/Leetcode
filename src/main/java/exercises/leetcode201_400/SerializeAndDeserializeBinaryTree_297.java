package exercises.leetcode201_400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import helper.TreeNode;

public class SerializeAndDeserializeBinaryTree_297 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodeQueue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodeQueue);
    }

    public TreeNode buildTree(Queue<String> queue) {
        if (!queue.isEmpty()) {
            String val = queue.poll();
            if (val.equals("null")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);

            return node;
        }

        return null;
    }
}
