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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<TreeNode> tmpL = new ArrayList<>();
            while (!q.isEmpty()) tmpL.add(q.poll());
            res.add(tmpL.get(tmpL.size() - 1).val);
            for (TreeNode n : tmpL) {
                if (null != n.left) q.add(n.left);
                if (null != n.right) q.add(n.right);
            }
        }
        return res;
    }
}