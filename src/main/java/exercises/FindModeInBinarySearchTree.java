package exercises;

import common.ContestProgrammingHelper;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].
 * Created by Ruochen on 04/02/2017.
 */

public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> occMap = new HashMap<>();
        findOcc(root, occMap);
        Map<Integer, Integer> sortedOccMap = ContestProgrammingHelper.sortByValue(occMap, false);
        return getMostFrequent(sortedOccMap);
    }

    private void findOcc(TreeNode node, Map<Integer, Integer> occMap) {
        if (node == null) {
            return;
        }

        if (occMap.containsKey(node.val)) {
            occMap.put(node.val, occMap.get(node.val) + 1);
        } else {
            occMap.put(node.val, 1);
        }

        findOcc(node.left, occMap);
        findOcc(node.right, occMap);
    }

    private int[] getMostFrequent(Map<Integer, Integer> sorted) {
        if (sorted.isEmpty()) {
            return new int[0];
        }

        ArrayList<Map.Entry<Integer, Integer>> occList = new ArrayList<>(sorted.entrySet());
        List<Integer> result = new ArrayList<>();
        result.add(occList.get(0).getKey());
        int index = 1;
        while (index < occList.size() && occList.get(index).getValue().equals(occList.get(index - 1).getValue())) {
            result.add(occList.get(index).getKey());
            index++;
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }
}