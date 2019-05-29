/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean HasSubtreeCore(TreeNode root1, TreeNode root2) {
        if (null != root2) {
            if (null == root1) {
                return false;
            }
            if (root1.val == root2.val) {
                return HasSubtreeCore(root1.left, root2.left) && HasSubtreeCore(root1.right, root2.right);
            } else {
                return false;
            }
        }

        return true;
    }
    
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (null == root2 || null == root1) {
            return false;
        }

        if (root1.val == root2.val && HasSubtreeCore(root1, root2)) {
            return true;
        }

        return (HasSubtree(root1.left, root2)) || (HasSubtree(root1.right, root2));
    }
}