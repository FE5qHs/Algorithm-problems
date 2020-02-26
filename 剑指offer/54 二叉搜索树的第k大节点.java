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

class Solution {
    private int idx = 0;
    private int res = 0;
    
    public int kthLargest(TreeNode root, int k) {
        int sum = nodeSum(root);
        find(root, sum - k + 1);
        return res;
    }
    
    private int nodeSum(TreeNode root) {
        if (null == root) return 0;
        int sum = 1;
        sum += nodeSum(root.left);
        sum += nodeSum(root.right);
        return sum;
    }
    
    private void find(TreeNode root, int aim) {
        if (null == root) return;
        find(root.left, aim);
        ++idx;
        if (idx == aim) res = root.val;
        find(root.right, aim);
    }
}