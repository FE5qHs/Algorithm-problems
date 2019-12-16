class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1, middle = 0;

        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] < target) low = middle + 1;
            else if (nums[middle] > target) high = middle - 1;
            else break;
        }

        int[] res = new int[]{-1, -1};
        if (nums.length == 0 || nums[middle] != target) return res;
        int tempIdx = middle;

        low = 0;
        high = tempIdx;
        while (low < high - 1) {
            middle = (low + high) / 2;
            if (nums[middle] < target) low = middle + 1;
            else if (nums[middle] >= target) high = middle;
        }
        if (nums[low] == target) res[0] = low;
        else res[0] = high;

        low = tempIdx;
        high = nums.length - 1;
        while (low < high - 1) {
            middle = (low + high) / 2;
            if (nums[middle] <= target) low = middle;
            else if (nums[middle] > target) high = middle - 1;
        }
        if (nums[high] == target) res[1] = high;
        else res[1] = low;

        return res;
    }
}