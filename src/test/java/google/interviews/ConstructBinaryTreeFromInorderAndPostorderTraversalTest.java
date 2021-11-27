package google.interviews;

import org.junit.Test;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {
    @Test
    public void testHappyCase() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
    }
}
