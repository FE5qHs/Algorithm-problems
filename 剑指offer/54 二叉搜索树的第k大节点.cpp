class Solution {
public:
    int kthLargest(TreeNode* root, int k) {
        int remainCount = countNode(root) - k + 1;
        int res = 0;
        findRes(root, remainCount, res);
        return res;
    }

    int countNode(TreeNode* root) {
        if (root == nullptr) return 0;
        return countNode(root->left) + countNode(root->right) + 1;
    }

    void findRes(TreeNode* root, int& remainCount, int& res) {
        if (root == nullptr) return;
        findRes(root->left, remainCount, res);
        if (--remainCount == 0) {
            res = root->val;
            return;
        }
        findRes(root->right, remainCount, res);
    }
};