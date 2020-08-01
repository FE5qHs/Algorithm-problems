class Solution {
public:
    void core(vector<int>& candidates, int target, vector<vector<int>>& res, 
              vector<int>& curArr, int cur, int start) {
        for (int i = start; i < candidates.size(); ++i) {
            curArr.push_back(candidates[i]);
            cur += candidates[i];
            if (cur == target) {
                res.push_back(vector<int>(curArr));
                curArr.erase(curArr.end() - 1);
                return;
            }
            if (cur > target) {
                curArr.erase(curArr.end() - 1);
                return;
            }
            core(candidates, target, res, curArr, cur, i);
            curArr.erase(curArr.end() - 1);
            cur -= candidates[i];
        }
        return;
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        vector<int> cur;
        core(candidates, target, res, cur, 0, 0);
        return res;
    }
};