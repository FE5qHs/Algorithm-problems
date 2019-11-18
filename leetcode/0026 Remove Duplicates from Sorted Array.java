class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums) return 0;
        if (nums.length <= 1) return nums.length;
        int a = 1;
        for (int b = 1; b < nums.length; ++b) {
            if (nums[b - 1] != nums[b]) {
                nums[a] = nums[b];
                ++a;
            }
        }
        return a;
    }
}