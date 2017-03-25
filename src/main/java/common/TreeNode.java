package common;

import static com.google.common.base.Objects.*;

/**
 * Created by Ruochen on 19/03/2017.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode that = (TreeNode) o;

        return equal(this.val, that.val) &&
                equal(this.left, that.left) &&
                equal(this.right, that.right);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(val, left, right);
    }
}
