class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length >= 4) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j - 1 >= i + 1 && nums[j - 1] == nums[j]) continue;
                    int low = j + 1, high = nums.length - 1;
                    while (low < high) {
                        int curSum = nums[i] + nums[j] + nums[low] + nums[high];
                        if (curSum < target) {
                            ++low;
                        } else if (curSum > target) {
                            --high;
                        } else {
                            List<Integer> newRes = new ArrayList<>();
                            newRes.add(nums[i]);
                            newRes.add(nums[j]);
                            newRes.add(nums[low]);
                            newRes.add(nums[high]);
                            res.add(newRes);
                            while (low < nums.length - 1 && nums[low] == nums[low + 1]) ++low;
                            ++low;
                        }
                    }
                }
            }
        }
        return res;
    }
}