// solution1
// time complexity O(n)
// space complexity O(n)
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

// solution2
// time complexity O(n)
// space complexity O(n)
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr) return nullptr;

        stack<TreeNode*> s;
        s.push(root);

        map<TreeNode*, TreeNode*> m;
        m[root] = nullptr;

        TreeNode* res1 = nullptr;
        TreeNode* res2 = nullptr;
        int cur = 0;
        while (!s.empty()) {
            TreeNode* tempNode = s.top();
            s.pop();

            if (tempNode == p || tempNode == q) {
                if (res1 == nullptr) res1 = tempNode;
                else res2 = tempNode;

                if (++cur == 2) break;
            }

            if (tempNode->left != nullptr) {
                s.push(tempNode->left);
                m[tempNode->left] = tempNode;
            }

            if (tempNode->right != nullptr) {
                s.push(tempNode->right);
                m[tempNode->right] = tempNode;
            }
        }

        set<TreeNode*> se;
        TreeNode* res = nullptr;

        while (res1 != nullptr) {
            se.insert(res1);

            res1 = m[res1];
        }

        while (res2 != nullptr) {
            if (se.find(res2) != se.end()) {
                res = res2;
                break;
            }
            
            res2 = m[res2];
        }

        return res;
    }
};