// solution1
// time complexity O(log(n))
// space complexity O(1)
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int low = 0, high = nums.size();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == nums.size() - 1 && nums[mid] == nums.size() - 1) return mid + 1;
            if (mid == 0 && nums[mid] != 0) return 0;
            if (mid > 0 && nums[mid - 1] + 1 != nums[mid]) return nums[mid] - 1;
            if (mid < nums.size() - 1 && nums[mid] + 1 != nums[mid + 1]) return nums[mid] + 1;
            if (nums[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
};

// solution2
// time complexity O(n)
// space complexity O(1)
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        for (int i = 0; i < nums.size(); ++i) {
            if (i != nums[i]) return i;
        }
        return nums.size();
    }
};

// solution3
// time complexity O(log(n))
// space complexity O(1)
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int low = 0, high = nums.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low == nums.size()) return low;
        if (low == 0 && nums[low] != 0) return 0;
        if (low > 0 && nums[low - 1] + 1 != nums[low]) return nums[low] - 1;
        if (low < nums.size() - 1 && nums[low] + 1 != nums[low + 1]) return nums[low] + 1;
        return 0;
    }
};