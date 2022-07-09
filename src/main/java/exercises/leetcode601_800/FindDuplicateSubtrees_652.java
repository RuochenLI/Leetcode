package exercises.leetcode601_800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import helper.TreeNode;

public class FindDuplicateSubtrees_652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        dfs(root, new HashMap<>(), result);

        return result;
    }

    public String dfs(TreeNode node, Map<String, Integer> countMap, List<TreeNode> result) {
        if (node == null) {
            return "#";
        }

        String serialization = dfs(node.left, countMap, result) +
                               "," +
                               dfs(node.right, countMap, result) +
                               "," +
                               node.val;
        int count = countMap.getOrDefault(serialization, 0) + 1;
        countMap.put(serialization, count);
        if (count == 2) {
            result.add(node);
        }
        return serialization;
    }

    int curId = 1;

    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<>();
        Map<Integer, Integer> idToCount = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        postorder(root, serialToId, idToCount, res);
        return res;
    }

    private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
        if (root == null) return 0;
        int leftId = postorder(root.left, serialToId, idToCount, res);
        int rightId = postorder(root.right, serialToId, idToCount, res);
        String curSerial = leftId + "," + root.val + "," + rightId;
        int serialId = serialToId.getOrDefault(curSerial, curId);
        if (serialId == curId) curId++;
        serialToId.put(curSerial, serialId);
        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        if (idToCount.get(serialId) == 2) res.add(root);
        return serialId;
    }
}
