class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if (root == nullptr) return true;
        bool isBalancedTree = true;
        core(root, 0, isBalancedTree);
        return isBalancedTree;
    }

    int core(TreeNode* root, int depth, bool& isBalancedTree) {
        if (!isBalancedTree) return -1;
        int leftDepth = ++depth, rightDepth = leftDepth;
        if (root->left != nullptr) leftDepth = core(root->left, depth, isBalancedTree);
        if (root->right != nullptr) rightDepth = core(root->right, depth, isBalancedTree);
        if (abs(leftDepth - rightDepth) > 1) isBalancedTree = false;
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
};