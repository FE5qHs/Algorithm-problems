/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/
class Solution {
public:
    void Mirror(TreeNode *pRoot) {
        if (nullptr == pRoot) {
            return;
        }

        TreeNode *temp = nullptr;

        temp = pRoot->left;
        pRoot->left = pRoot->right;
        pRoot->right = temp;

        Mirror(pRoot->left);
        Mirror(pRoot->right);

        return;
    }
};