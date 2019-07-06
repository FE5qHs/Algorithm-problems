import java.util.ArrayList;
import java.util.Collections;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (null != root) {
            ArrayList<Integer> path = new ArrayList<>();
            Core(result, path, root, 0, target);
        }
        return result;
    }
    
    private void Core(ArrayList<ArrayList<Integer>> result,
                             ArrayList<Integer> path, TreeNode node, int current, int target) {
        current += node.val;
        ArrayList<Integer> curPath = new ArrayList<>();
        curPath.addAll(path);
        curPath.add(node.val);
        if (current == target && null == node.left && null == node.right) {
            int i = 0;
            for (; i < result.size(); ++i) {
                if (result.get(i).size() < curPath.size()) {
                    result.add(curPath);
                    for (int j = result.size() - 1; j > i; --j) {
                        Collections.swap(result, j - 1, j);
                    }
                    break;
                }
            }
            if (0 == i || result.size() == i) {
                result.add(curPath);
            }
        }

        if (null != node.left) {
            Core(result, curPath, node.left, current, target);
        }
        if (null != node.right) {
            Core(result, curPath, node.right, current, target);
        }
    }
}