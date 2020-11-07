class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        return core(root, 0);
    }

    int core(TreeNode* root, int depth) {
        int leftDepth = ++depth, rightDepth = leftDepth;
        if (root->left != nullptr) leftDepth = core(root->left, depth);
        if (root->right != nullptr) rightDepth = core(root->right, depth);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
};