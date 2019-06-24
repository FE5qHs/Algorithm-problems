import java.util.ArrayList;
import java.util.LinkedList;

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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        while (l.size() != 0) {
            TreeNode n = l.getFirst();
            l.remove(0);
            result.add(n.val);
            if (null != n.left) {
                l.add(n.left);
            }
            if (null != n.right) {
                l.add(n.right);
            }
        }

        return result;
    }
}