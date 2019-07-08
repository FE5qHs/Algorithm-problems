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
    private TreeNode pre = null;
    private TreeNode cur = null;
    private TreeNode head = null;
    private boolean isStart = false;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }

        Convert(pRootOfTree.left);

        if (!isStart) {
            isStart = true;
            head = pRootOfTree;
        }

        if (isStart) {
            pre = cur;
            cur = pRootOfTree;

            if (null != pre) {
                cur.left = pre;
                pre.right = cur;
            }
        }

        Convert(pRootOfTree.right);

        return head;
    }
}