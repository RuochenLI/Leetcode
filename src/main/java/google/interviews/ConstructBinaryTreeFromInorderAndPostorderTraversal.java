package google.interviews;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) {
                return null;
            }

            if (inorder.length == 1) {
                return new TreeNode(inorder[0]);
            }

            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            int index = findIndex(inorder, root.val);
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
            root.right = buildTree(Arrays.copyOfRange(inorder, index + 1, postorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
            return root;
     }

    private int findIndex(int[] inorder, int val) {
        int pointer = 0;
        while (pointer < inorder.length) {
            if (inorder[pointer] == val) {
                return pointer;
            }
            pointer++;
        }
         return -1;
    }

}