/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/

import java.util.LinkedList;

public class Solution {
    public String Serialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        LinkedList<TreeNode> l = new LinkedList<>();
        l.addFirst(root);

        StringBuilder result = new StringBuilder();
        while (0 != l.size()) {
            TreeNode t = l.removeLast();
            if (0 != result.length()) {
                result.append(",");
            }
            if (null != t) {
                result.append(t.val);
                if (null == t.left && null == t.right) {
                    continue;
                }
                l.addFirst(t.left);
                l.addFirst(t.right);
            } else {
                result.append("#");
            }
        }
        return result.toString();
    }

    public TreeNode Deserialize(String str) {
        if (str.equals("")) {
            return null;
        }
        String[] arr = str.split(",", -1);

        LinkedList<TreeNode> l = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        l.addLast(root);
        int idx = 1;
        while (0 != l.size()) {
            TreeNode temp = l.removeFirst();
            if (idx < arr.length && !arr[idx].equals("#")) {
                temp.left = new TreeNode(Integer.parseInt(arr[idx]));
                l.addLast(temp.left);
            }
            ++idx;
            if (idx < arr.length && !arr[idx].equals("#")) {
                temp.right = new TreeNode(Integer.parseInt(arr[idx]));
                l.addLast(temp.right);
            }
            ++idx;
        }
        return root;
    }
}