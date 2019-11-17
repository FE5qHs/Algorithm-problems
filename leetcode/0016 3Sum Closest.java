class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 10000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int current = nums[i] + nums[low] + nums[high];
                if (Math.abs(current - target) < Math.abs(result - target)) {
                    result = current;
                }
                if (current - target < 0) {
                    while (low < nums.length - 1 && nums[low] == nums[low + 1]) ++low;
                    ++low;
                } else if (current - target > 0) {
                    while (i + 1 < high && nums[high] == nums[high - 1]) --high;
                    --high;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}