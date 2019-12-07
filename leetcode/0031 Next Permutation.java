class Solution {
    public void nextPermutation(int[] nums) {
        if (null == nums || 0 == nums.length) return;
        int rightEle = nums[nums.length - 1];
        int rightIdx = nums.length - 1;
        int leftIdx = 0;
        boolean flag = false;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (rightEle > nums[i]) {
                leftIdx = i;
                flag = true;
                break;
            } else if (nums[i] > rightEle) {
                rightEle = nums[i];
                rightIdx = i;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
            return;
        }
        int leftEle = nums[leftIdx];
        for (int i = nums.length - 1; i > leftIdx; --i) {
            if (nums[i] > leftEle && nums[i] < rightEle) {
                rightEle = nums[i];
                rightIdx = i;
            }
        }
        swap(nums, leftIdx, rightIdx);
        Arrays.sort(nums, leftIdx + 1, nums.length);
        return;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}