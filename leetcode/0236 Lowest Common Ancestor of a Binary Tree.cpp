class Solution {
public:
    TreeNode* result;

    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        helper(root, p, q);
        return result;
    }

    int helper(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (result != nullptr || root == nullptr) return 0;

        int ret = 0;
        if (root == p || root == q) ++ret;

        ret += helper(root->left, p, q);
        ret += helper(root->right, p, q);

        if (ret == 2 && result == nullptr) result = root;
        return ret;
    }
};