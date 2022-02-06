package exercises;

import helper.TreeNode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 04/02/2017.
 */
public class MostFrequentSubtreeSumTest {

    @Test
    public void testCase1() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-5);
        TreeNode root = new TreeNode(5);

        root.left = left;
        root.right = right;

        int[] frequentTreeSum = new MostFrequentSubtreeSum().findFrequentTreeSum(root);
        assertEquals(frequentTreeSum.length, 1);
        assertEquals(frequentTreeSum[0], 2);

    }

    @Test
    public void testCase2() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        node3.left = node1;
        node3.right = node2;
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(3);
        node5.left = node3;
        node5.right = node4;

        int[] frequentTreeSum = new MostFrequentSubtreeSum().findFrequentTreeSum(node5);
        assertEquals(frequentTreeSum.length, 1);
        assertEquals(frequentTreeSum[0], 6);

    }
}
