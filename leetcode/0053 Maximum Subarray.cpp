class Solution {
public:
    int maxSubArray(vector<int>& nums) {
    	if (nums.size() == 0) return 0;

	    int max = nums[0];
	    for (int i = 0; i < nums.size(); ++i) {
	        int cur = 0;
	        for (int j = i; j < nums.size(); ++j) {
	            cur += nums[j];
	            if (cur > max) max = cur;
	        }
	    }

	    return max;
    }
};