package exercises.leetcode1201_1400;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllElementInTwoBinarySearchTree_1305 {
    LinkedList<Integer> treeList1;
    LinkedList<Integer> treeList2;
    List<Integer> result;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        treeList1 = new LinkedList<>();
        treeList2 = new LinkedList<>();
        result = new ArrayList<>();
        visit(root1, treeList1);
        visit(root2, treeList2);

        while (!treeList1.isEmpty() || !treeList2.isEmpty()) {
            if (!treeList1.isEmpty() && (treeList2.isEmpty() || treeList1.peek() <= treeList2.peek())) {
                result.add(treeList1.poll());
            } else {
                result.add(treeList2.poll());
            }
        }

        return result;
    }

    public void visit(TreeNode node, LinkedList<Integer> list) {
        if (node == null) return;

        if (node.left != null) {
            visit(node.left, list);
        }

        list.offer(node.val);

        if (node.right != null) {
            visit(node.right, list);
        }
    }
}
