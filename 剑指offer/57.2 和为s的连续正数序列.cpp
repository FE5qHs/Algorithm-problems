class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
        vector<vector<int>> res;
        int cur = 0;
        for (int low = 1, high = 1; low < target && high < target;) {
            if (cur < target) {
                cur += high++;
            } else if (cur > target) {
                cur -= low++;
            }
            if (cur == target) {
                vector<int> newRes;
                for (int i = low; i < high; ++i) newRes.push_back(i);
                res.push_back(newRes);
                cur += high++;
            }
        }
        return res;
    }
};