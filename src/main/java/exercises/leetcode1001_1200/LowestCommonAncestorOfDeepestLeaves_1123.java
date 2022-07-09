package exercises.leetcode1001_1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import helper.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(null, 0);
        }
        Result L = dfs(node.left), R = dfs(node.right);
        if (L.dist > R.dist) {
            return new Result(L.node, L.dist + 1);
        }
        if (L.dist < R.dist) {
            return new Result(R.node, R.dist + 1);
        }
        return new Result(node, L.dist + 1);
    }

    /**
     * The result of a subtree is:
     * Result.node: the largest depth node that is equal to or
     * an ancestor of all the deepest nodes of this subtree.
     * Result.dist: the number of nodes in the path from the root
     * of this subtree, to the deepest node in this subtree.
     */
    class Result {
        TreeNode node;
        int dist;

        Result(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }

    List<TreeNode> deepestLeaves;
    Map<TreeNode, TreeNode> parent;
    Map<TreeNode, Integer> nodeLevel;

    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        if (root == null) {
            return null;
        }
        parent = new HashMap<>();
        nodeLevel = new HashMap<>();
        buildParentAndDeepestNodesList(root);
        if (deepestLeaves.size() == 1) {
            return deepestLeaves.get(0);
        }
        Set<TreeNode> pathSet = buildPathSet();
        return findLowestCommonAncestor(pathSet);
    }

    private TreeNode findLowestCommonAncestor(final Set<TreeNode> pathSet) {
        TreeNode p;
        int lowest = Integer.MAX_VALUE;
        TreeNode result = null;
        for (int i = 1; i < deepestLeaves.size(); i++) {
            p = deepestLeaves.get(i);
            while (!pathSet.contains(p)) {
                p = parent.get(p);
            }
            if (nodeLevel.get(p) < lowest) {
                lowest = nodeLevel.get(p);
                result = p;
            }
        }
        return result;
    }

    private Set<TreeNode> buildPathSet() {
        Set<TreeNode> pathSet = new HashSet<>();
        TreeNode p = deepestLeaves.get(0);
        while (parent.containsKey(p)) {
            pathSet.add(p);
            p = parent.get(p);
        }
        pathSet.add(p);
        return pathSet;
    }

    private void buildParentAndDeepestNodesList(final TreeNode root) {
        int maxLevel = -1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        nodeLevel.put(root, 0);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int level = nodeLevel.get(node);
            if (level >= maxLevel) {
                if (level > maxLevel) {
                    maxLevel = level;
                    deepestLeaves = new ArrayList<>();
                }
                deepestLeaves.add(node);
            }

            if (node.left != null) {
                parent.put(node.left, node);
                nodeLevel.put(node.left, level + 1);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                nodeLevel.put(node.right, level + 1);
                stack.push(node.right);
            }
        }
    }
}
