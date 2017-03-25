import common.TreeNode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ruochen on 25/03/2017.
 */
public class ConvertBSTToGreaterTreeTest {

    @Test
    public void testCase1() {
        TreeNode node1 =new TreeNode(5);
        TreeNode node2 =new TreeNode(2);
        TreeNode node3 =new TreeNode(13);

        node1.right = node3;
        node1.left = node2;

        TreeNode expectedNode1 =new TreeNode(18);
        TreeNode expectedNode2 =new TreeNode(20);
        TreeNode expectedNode3 =new TreeNode(13);

        expectedNode1.right = expectedNode3;
        expectedNode1.left = expectedNode2;
        assertEquals(expectedNode1, new ConvertBSTToGreaterTree().convertBST(node1));
    }
}
