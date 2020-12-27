class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        map<int, int> m;
        int left = 0, right = k - 1;

        for (int i = left; i <= right; ++i) {
            if (m.find(nums[i]) != m.end()) {
                ++m[nums[i]];
            } else {
                m[nums[i]] = 1;
            }
        }

        vector<int> res;
        res.push_back((--m.end())->first);

        while (right < nums.size() - 1) {
            if (m[nums[left]] == 1) {
                m.erase(nums[left]);
            } else {
                --m[nums[left]];
            }
            ++left;

            ++right;
            if (m.find(nums[right]) != m.end()) {
                ++m[nums[right]];
            } else {
                m[nums[right]] = 1;
            }

            res.push_back((--m.end())->first);
        }
        return res;
    }
};