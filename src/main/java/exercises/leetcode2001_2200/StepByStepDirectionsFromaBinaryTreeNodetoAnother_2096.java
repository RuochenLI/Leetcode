package exercises.leetcode2001_2200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import helper.TreeNode;

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother_2096 {
    String s;
    String d;

    private void find(TreeNode n, int start, int dest, StringBuilder sb) {
        if (n == null || s != null && d != null) {
            return;
        }

        if (n.val == start) {
            s = sb.toString();
        }
        if (n.val == dest) {
            d = sb.toString();
        }

        if (n.left != null) {
            sb.append("L");
            find(n.left, start, dest, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (n.right != null) {
            sb.append("R");
            find(n.right, start, dest, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        s = null;
        d = null;
        find(root, startValue, destValue, new StringBuilder());
        int i = 0, max_i = Math.min(d.length(), s.length());
        while (i < max_i && s.charAt(i) == d.charAt(i)) {
            ++i;
        }
        return "U".repeat(s.length() - i) + d.substring(i);
    }

    private boolean find1(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val) {
            return true;
        }
        if (n.left != null && find1(n.left, val, sb)) {
            sb.append("L");
        } else if (n.right != null && find1(n.right, val, sb)) {
            sb.append("R");
        }
        return sb.length() > 0;
    }

    public String getDirections1(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        find1(root, startValue, s);
        find1(root, destValue, d);
        int i = 0, max_i = Math.min(d.length(), s.length());
        while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1)) {
            ++i;
        }
        return "U".repeat(s.length() - i) + d.reverse().substring(i);
    }

    public String getDirections0(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return "";
        }

        LinkedList<TreeNode> steak = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode start = null;
        TreeNode dest = null;
        steak.push(root);

        while (!steak.isEmpty() || start == null || dest == null) {
            TreeNode node = steak.pop();
            if (node.val == startValue) {
                start = node;
            }
            if (node.val == destValue) {
                dest = node;
            }
            if (node.left != null) {
                parent.put(node.left, node);
                steak.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                steak.push(node.right);
            }
        }

        Set<TreeNode> visitNodes = new HashSet<>();
        TreeNode pointer = dest;
        while (parent.containsKey(pointer)) {
            visitNodes.add(pointer);
            pointer = parent.get(pointer);
        }
        visitNodes.add(pointer);

        pointer = start;
        StringBuilder sb = new StringBuilder();
        while (!visitNodes.contains(pointer)) {
            sb.append("U");
            pointer = parent.get(pointer);
        }
        while (pointer != dest) {
            if (visitNodes.contains(pointer.left)) {
                sb.append("L");
                pointer = pointer.left;
            } else {
                sb.append("R");
                pointer = pointer.right;
            }
        }
        return sb.toString();
    }
}
