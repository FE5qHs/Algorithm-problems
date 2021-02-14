class Solution {
public:
    bool isStraight(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int i = 0, zeroSum = 0;
        while (nums[i] == 0 && i < nums.size()) {
            ++zeroSum;
            ++i;
        }

        int gapSum = 0;
        if (i < nums.size()) {
            ++i;
        } else {
            return true;
        }
        while (i < nums.size()) {
            if (nums[i] == nums[i - 1]) return false;
            gapSum += nums[i] - nums[i - 1] - 1;
            ++i;
        }

        return gapSum <= zeroSum;
    }
};