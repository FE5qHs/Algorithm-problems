/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return root;
        
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (null == root) return root;
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode t = s.pop();
            
            TreeNode temp = null;
            temp = t.left;
            t.left = t.right;
            t.right = temp;
            
            if (null != t.left) s.push(t.left);
            if (null != t.right) s.push(t.right);
        }
        
        return root;
    }
}