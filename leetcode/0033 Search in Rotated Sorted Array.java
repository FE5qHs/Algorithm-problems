class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || 0 == nums.length) return -1;
        int left = 0, right = nums.length - 1, pivot = 0, result = -1, middle;
        while (left != right) {
            middle = (left + right) / 2;
            if (nums[left] > nums[middle] && nums[middle] < nums[right]) {
                right = middle;
            } else if (nums[left] < nums[middle] && nums[middle] > nums[right]) {
                left = middle;
            } else if (nums[left] > nums[right]) {
                pivot = right;
                break;
            } else {
                pivot = left;
                break;
            }
        }
        left = 0;
        right = pivot - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                result = middle;
                break;
            }
        }
        left = pivot;
        right = nums.length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                result = middle;
                break;
            }
        }
        return result;
    }
}