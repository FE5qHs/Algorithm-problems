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
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        add(root, arr);
        return arr.get(arr.size() - k);
    }
    
    private void add(TreeNode root, ArrayList<Integer> arr) {
        if (null == root) return;
        add(root.left, arr);
        arr.add(root.val);
        add(root.right, arr);
    }
}