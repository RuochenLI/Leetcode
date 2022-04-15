package exercises.leetcode801_1000;

import helper.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree_987 {

    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new LinkedList<>();
        for (int key : map.keySet()){
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
            for (int k : tm.keySet()){
                PriorityQueue<Integer> pq = tm.get(k);
                while (!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }

    private void dfs(TreeNode root, int index, int level){
        if (root == null)
            return;

        map.putIfAbsent(index, new TreeMap<>());
        map.get(index).putIfAbsent(level, new PriorityQueue<>());
        map.get(index).get(level).add(root.val);
        dfs(root.left, index - 1, level + 1);
        dfs(root.right, index + 1, level + 1);
    }
//    Map<Integer, PriorityQueue<TreeNode>> nodeMap;
//    Map<TreeNode, Integer> rowLevelNodeMap;
//    Map<TreeNode, Integer> columnLevelNodeMap;
//    int left, right;
//
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        nodeMap = new HashMap<>();
//        rowLevelNodeMap = new HashMap<>();
//        columnLevelNodeMap = new HashMap<>();
//        left = 0;
//        right = 0;
//        visit(root, 0, 0);
//        return buildResult();
//    }
//
//    public List<List<Integer>> buildResult() {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = left; i <= right; i++) {
//            List<Integer> rowNodes = new ArrayList<>();
//            PriorityQueue<TreeNode> queue = nodeMap.get(i);
//            while (!queue.isEmpty()) {
//                TreeNode node = queue.poll();
//                rowNodes.add(node.val);
//            }
//            result.add(rowNodes);
//        }
//        return result;
//    }
//
//    public void visit(TreeNode node, int rowLevel, int columnLevel) {
//        if (node == null)  return;
//
//        left = Math.min(left, columnLevel);
//        right = Math.max(right, columnLevel);
//        rowLevelNodeMap.put(node, rowLevel);
//        columnLevelNodeMap.put(node, columnLevel);
//        PriorityQueue<TreeNode> queue = nodeMap.getOrDefault(columnLevel,
//                new PriorityQueue<>((a, b) ->
//                        Objects.equals(rowLevelNodeMap.get(a), rowLevelNodeMap.get(b)) ?
//                                columnLevelNodeMap.get(a) - columnLevelNodeMap.get(b) :
//                                rowLevelNodeMap.get(a) - rowLevelNodeMap.get(b)));
//        queue.offer(node);
//        nodeMap.put(columnLevel, queue);
//        visit(node.left, rowLevel + 1, columnLevel - 1);
//        visit(node.right, rowLevel + 1, columnLevel + 1);
//    }

}
