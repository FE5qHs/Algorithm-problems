/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};
*/
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
    }

    void preOrder(TreeNode* pRoot, vector<string>&arr) {
        if (nullptr == pRoot) {
            arr.push_back("#");
            return;
        }

        arr.push_back(to_string(pRoot->val));
        preOrder(pRoot->left, arr);
        preOrder(pRoot->right, arr);
    }

    void inOrder(TreeNode* pRoot, vector<string>&arr) {
        if (nullptr == pRoot) {
            arr.push_back("#");
            return;
        }

        inOrder(pRoot->left, arr);
        arr.push_back(to_string(pRoot->val));
        inOrder(pRoot->right, arr);
    }

    bool isSymmetrical(TreeNode* pRoot) {
        vector<string>preArr;
        vector<string>inArr;
        preOrder(pRoot, preArr);
        inOrder(pRoot, inArr);

        Mirror(pRoot);

        vector<string>mirrorPreArr;
        vector<string>mirrorInArr;
        preOrder(pRoot, mirrorPreArr);
        inOrder(pRoot, mirrorInArr);

        for (int i = 0; i < preArr.size(); ++i)
            if (preArr[i] != mirrorPreArr[i] || inArr[i] != mirrorInArr[i])
                return false;

        return true;
    }
};