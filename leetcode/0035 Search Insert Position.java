class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length, mi = 0;
        while (lo < hi) {
            mi = (lo + hi) / 2;
            if (nums[mi] < target) lo = mi + 1;
            else if (nums[mi] > target) hi = mi - 1;
            else break;
        }
        if (0 == nums.length || nums[mi] == target) return mi;
        else if (lo == nums.length || nums[lo] >= target) return lo;
        else return lo + 1;
    }
}