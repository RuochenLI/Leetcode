import common.ContestProgrammingHelper;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 *
 * Created by Ruochen on 04/02/2017.
 */
public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<TreeNode, Integer> subTreeValue = new HashMap<>();
        calculateSum(root, subTreeValue);
        Map<Integer, Integer> sorted = orderByOccurrence(subTreeValue);
        return getMostFrequentSubTree(sorted);

    }

    private int[] getMostFrequentSubTree(Map<Integer, Integer> sorted) {
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

    private Map<Integer, Integer> orderByOccurrence(Map<TreeNode, Integer> subTreeValue) {
        Map<Integer, Integer> occ = new HashMap<>();
        subTreeValue.values().forEach(integer -> {
            if (occ.containsKey(integer)) {
                occ.put(integer, occ.get(integer) + 1);
            } else {
                occ.put(integer, 1);
            }

        });

        return ContestProgrammingHelper.sortByValue(occ, false);
    }

    private int calculateSum(TreeNode node, Map<TreeNode, Integer> subTreeValue) {
        if (node == null) {
            return 0;
        }

        if (subTreeValue.containsKey(node)) {
            return subTreeValue.get(node);
        }

        int value = node.val + calculateSum(node.left, subTreeValue) + calculateSum(node.right, subTreeValue);
        subTreeValue.put(node, value);
        return value;
    }
}
