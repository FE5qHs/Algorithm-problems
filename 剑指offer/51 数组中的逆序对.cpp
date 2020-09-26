class Solution {
public:
    int reversePairs(vector<int>& nums) {
        int res = 0;
        if (nums.size() > 0) divideAndConquer(nums, 0, nums.size() - 1, res);
        return res;
    }
    
    vector<int> divideAndConquer(vector<int>& nums, int low, int high, int& res) {
        if (low >= high) return vector<int>{nums[low]};

        vector<int> res1 = divideAndConquer(nums, low, low + (high - low) / 2, res);
        vector<int> res2 = divideAndConquer(nums, low + (high - low) / 2 + 1, high, res);
        
        vector<int> temp(res1.size() + res2.size());
        int start1 = 0, start2 = 0, startT = 0;
        int res1End = res1.size() - 1, res2End = res2.size() - 1;
        while (start1 <= res1End && start2 <= res2End) {
            if (res1[start1] <= res2[start2]) {
                temp[startT++] = res1[start1++];
            } else {
                temp[startT++] = res2[start2++];
                res += res1End - start1 + 1;
            }
        }
        while (start1 <= res1End) {
            temp[startT++] = res1[start1++];
        }
        while (start2 <= res2End) {
            temp[startT++] = res2[start2++];
        }
        
        return temp;
    }
};