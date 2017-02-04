import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 04/02/2017.
 */
public class MostFrequentSubtreeSumTest {

    @Test
    public void testCase1() {
        MostFrequentSubtreeSum.TreeNode left = new MostFrequentSubtreeSum.TreeNode(2);
        MostFrequentSubtreeSum.TreeNode right = new MostFrequentSubtreeSum.TreeNode(-5);
        MostFrequentSubtreeSum.TreeNode root = new MostFrequentSubtreeSum.TreeNode(5);

        root.left = left;
        root.right = right;

        int[] frequentTreeSum = new MostFrequentSubtreeSum().findFrequentTreeSum(root);
        assertEquals(frequentTreeSum.length, 1);
        assertEquals(frequentTreeSum[0], 2);

    }

    @Test
    public void testCase2() {
        MostFrequentSubtreeSum.TreeNode node1 = new MostFrequentSubtreeSum.TreeNode(5);
        MostFrequentSubtreeSum.TreeNode node2 = new MostFrequentSubtreeSum.TreeNode(0);
        MostFrequentSubtreeSum.TreeNode node3 = new MostFrequentSubtreeSum.TreeNode(1);
        node3.left = node1;
        node3.right = node2;
        MostFrequentSubtreeSum.TreeNode node4 = new MostFrequentSubtreeSum.TreeNode(6);
        MostFrequentSubtreeSum.TreeNode node5 = new MostFrequentSubtreeSum.TreeNode(3);
        node5.left = node3;
        node5.right = node4;

        int[] frequentTreeSum = new MostFrequentSubtreeSum().findFrequentTreeSum(node5);
        assertEquals(frequentTreeSum.length, 1);
        assertEquals(frequentTreeSum[0], 6);

    }
}
