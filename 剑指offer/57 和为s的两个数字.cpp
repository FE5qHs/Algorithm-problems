class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        for (int i = 0, j = nums.size() - 1; i != j;) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                res.push_back(nums[i]);
                res.push_back(nums[j]);
                return res;
            } else if (sum > target) {
                --j;
            } else {
                ++i;
            }
        }
        return res;
    }
};