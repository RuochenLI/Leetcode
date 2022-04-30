package exercises.leetcode201_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.TreeNode;

public class FindLeavesOfBinaryTree_366 {    public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> depthMap = new HashMap<>();
    int depth = getDepth(root, depthMap);
    for (int i = 1; i <= depth; i++) {
        result.add(depthMap.get(i));
    }
    return result;
}

    private int getDepth(TreeNode node, Map<Integer, List<Integer>> depthMap) {
        if (node == null) {
            return 0;
        }

        int depth = Math.max(getDepth(node.left, depthMap), getDepth(node.right, depthMap)) + 1;
        List<Integer> depthList = depthMap.getOrDefault(depth, new ArrayList<>());
        depthList.add(node.val);
        depthMap.put(depth, depthList);
        return depth;
    }

}
